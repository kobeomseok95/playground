# 내용 정리
## 키워드
### 의존성
- 객체 내에서 타 객체의 세부사항에 알고 있음을 의미
- 의존성을 완전히 없애기 보다 적절하게 서로를 협력시키는 것이 중요
- 의존성이 지나치다는 것은 의존하고 있는 객체가 변경될 경우, 동시에 변경될 가능성이 상당히 높음
    - 이렇게 되면 변경에 굉장히 취약해짐
### 결합도
- 객체 사이에 의존성이 과한 경우를 `결합도가 높다` 라고 표현한다.
- 반대로, 객체들이 합리적인 수준으로 의존할 경우는 `결합도가 낮다`고 표현한다.
### 책임
- 객체지향 패러다임에서 '기능'을 의미
### 캡슐화
- 객체의 세부사항을 감추는 것
- 변경하기 쉬운 객체를 만들기 위함 + 객체간 결합도를 줄일 수 있음
- 객체의 내부 상태를 캡슐화하고, 객체 간에 오직 메세지를 통해서 상호작용하게 만들
### 인터페이스와 구현
- 개선 후 `Theater` 객체는 `TicketSeller`의 인터페이스에만 의존한다.
- `TicketSeller`가 `TicketOffice` 인스턴스를 포함하는 사실은 구현의 영역에 속한다.
- 이처럼 객체를 인터페이스와 구현으로 나누고 인터페이스만을 공개하는 것은 객체 사이의 결합도를 낮추고 변경하기 쉬운 코드를 작성하게 해준다. 가장 기본적인 설계 원칙 
### 응집도
- 밀접하게 연관된 작업만을 수행하고, 연관성 없는 작업은 다른 객체에게 위임하는 객체를 가리켜 `응집도가 높다` 라고 표현한다.
- 자신의 데이터를 스스로 처리하는 자율적인 객체를 만들면 결합도를 낮추고 응집성을 높일 수 있다.
- 즉, 객체는 자신의 데이터를 스스로 처리하는 자율적인 존재여야 한다.

## 객체 지향
> 데이터와 프로세스가 동일한 모듚 내부에 위치하도록 프로그래밍 하는 방식
- 캡슐화를 이용해 의존성을 적절히 관리함으로써 객체 사이의 결합도를 낮추기
- 객체지향 설계의 핵심은 적절한 책임을 적절한 객체에게 할당하는 것

## 소프트웨어 모듈의 세 가지 목적
- 실행 중에 제대로 동작
- 변경을 위해 존재하는 것
- 코드를 읽는 사람과 의사소통하는 것

## 개선과정
다음과 같은 요구 사항이 있다.
- 소극장에서 연극을 볼 수 있는 티켓을 판매한다.
- 이 중 이벤트 당첨자는 공연을 무료로 관람할 수 있다.
- 이벤트 미당첨자는 티켓 비용을 지불해야 한다.

```java
public class Theater {
    private TicketSeller ticketSeller;
    
    // Constructor
    
    public void enter(Audience audience) {
        if (audience.getBag().hasInvocation()) {
            Ticket ticket = ticketSeller.getTicketOffice().getTicket();
            audience.getBag().setTicket(ticket);
        } else {
            Ticket ticket = ticketSeller.getTicketOffice().getTicket();
            audience.getBag().minusAmount(ticket.getFee());
            ticketSeller.getTicketOffice().plusAmount(ticket.getFee());
            audience.getBag().setTicket(ticket);
        }
    }
}
```
위 코드의 문제점은 `Audience` 가 `Bag`에서 티켓을 저장하는 책임, 
`TicketSeller` 객체의 티켓을 빼고 판매 금액을 설정하는 책임을 알고 있기 때문에 결합도가 올라갔다.
따라서, 현재 코드 처럼 각 클래스에 위치한 데이터와 프로세스의 동일한 모듈에 위치시켰다.
