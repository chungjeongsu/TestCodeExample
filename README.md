# 테스트코드 예제
## 간단한 카페 키오스크

---

### 1. 주문 목록에 음료 추가, 삭제 기능

### 2. 주문 목록 전체 지우기

### 3. 주문 목록 총 금액 계산하기

### 4. 주문 생성하기

---

## CHAPTER 1 : 자동화된 테스트를 실행하라.

```java
    @Test
    void add(){
        CafeKiosk cafeKiosk = new CafeKiosk();
        cafeKiosk.add(new Americano());

        System.out.println(">>> 담긴 음료 수 : " + cafeKiosk.getBeverages().size());
        System.out.println(">>> 담긴 음료 : " + cafeKiosk.getBeverages().get(0).getName());
    }
```

- add에 대한 테스트이지만, 어떤 것이 옳은 결과인지 알 수 없다.
- 즉, 옳은(혹은 틀린) 결과를 확인하는 내용이 들어가는 테스트를 짜자.
- 다만, 작은 코드 단위를 독립적으로 검증해야한다.
- 이는 모듈화가 잘 되어있어야 함을 의미한다.

---

## CHAPTER 2 : 단위 테스트 자동화를 위한 Junit/AssertJ

### happy case

- 기능이 잘 되는가?

### exception case

- 기능에서 발생할 수 있는 예외가 처리되었는가?

---

## CHAPTER 3 : 단위 테스트를 위한 분리

- 우리는 아래의 코드에서 시간에 따른 비즈니스 로직의 반응을 테스트하고 싶다.

````java
    public Order createOrder(){
        LocalDateTime now = LocalDateTime.now();
        LocalTime currentTime = now.toLocalTime();

        if(currentTime.isBefore(SHOP_OPEN_TIME) || currentTime.isAfter(SHOP_CLOSE_TIME)){
            throw new IllegalArgumentException("주문 시간이 아닙니다. 관리자에게 문의하세요.");
        }

        return new Order(LocalDateTime.now(), beverages);
    }
````

- 젠장, `LocalDateTime.now()` 때문에 테스트가 힘들어졌다.
- LocalDateTime에 createOrder()라는 메서드가 의존하고 있다.
- 예외가 발생할때까지 시간을 기다릴 것인가? 아니다. 코드를 바꿔보자.
- 우리는 LocalDateTime 자체의 테스트가 아니라, LocalDateTime에 따른 비즈니스 로직을 테스트해야한다.

````java
    public Order createOrder(LocalDateTime currentDateTime){
        LocalTime currentTime = currentDateTime.toLocalTime();

        if(currentTime.isBefore(SHOP_OPEN_TIME) || currentTime.isAfter(SHOP_CLOSE_TIME)){
            throw new IllegalArgumentException("주문 시간이 아닙니다. 관리자에게 문의하세요.");
        }

        return new Order(LocalDateTime.now(), beverages);
    }
````

- 메서드 밖에서 LocalDateTime을 받도록 분리시켜줬다.
- 이제 테스트에서는 LocalDateTime을 받아 사용하면 된다.
- 이처럼, 하나의 모듈이 다른 모듈을 `의존`하게 하면 안된다.
- 다만, input을 받아 `협력`하게 하자.

---

## CHAPTER 4 : 테스트하기 어려운 영역 확인 후 해결책 알아보기

- 위의 `LocalDateTime`처럼 테스트하기 어려운 모듈은 뭐가 있을까? 알아보자.

### 4-1. 관측할 때마다 다른 값에 의존하는 코드

#### 4-1-1. 종류

`LocalDateTime.now()`

`UUID.randomUUID()`

`System.currentTimeMillis()`

`Math.random()`

### 4-2. 외부 모듈에 영향을 주는 코드(API, DB 통신 등 네트워크 I/O)

#### 4-2-1. 종류

`DB 접근(JPA : save(), findById() 등)`

`외부 API 접근(webClient.{method}, redisTemplate.{method}, file I/O)`

### 4-3. 해결책

- 그냥 외부로 분리하자.
- 그 값을 받아서 사용하는 모듈은 그냥 객체를 만들어 테스트한다.
- 만약, 외부 API 응답도 테스트가 필요하다면, 찾아서 그 모듈만 테스트한다.

---


