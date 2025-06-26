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

