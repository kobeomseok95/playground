package chapter_04.ex1;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //        1번 예제
        List<BaseballPlayer> players = init();

        players.sort((BaseballPlayer o1, BaseballPlayer o2) -> o1.getPlayerName().compareTo(o2.getPlayerName()));
        for (BaseballPlayer player : players) {
            System.out.println("player = " + player.getPlayerName());

        }

//        2번 예제
        Thread thread = new Thread(() -> System.out.println("Hello World!"));
        thread.start();
        Runnable runnableImpl = getRunnable();
        Thread thread2 = new Thread(runnableImpl);
        thread2.start();    //호출 시점에 정의한 리턴 메서드 실행
    }

    private static Runnable getRunnable() {
        return () -> System.out.println("이곳은 Runnable 정의 부분이다. 절대 sout이 실행되는 것이 아님.");
    }

    private static List<BaseballPlayer> init() {
        List<BaseballPlayer> players = new ArrayList<>();

        BaseballPlayer b1 = new BaseballPlayer("팀1", "고범석", "외야수", 1);
        players.add(b1);

        BaseballPlayer b2 = new BaseballPlayer("팀1", "고읍석", "외야수", 2);
        players.add(b2);

        BaseballPlayer b3 = new BaseballPlayer("팀1", "고좆석", "외야수", 3);
        players.add(b3);

        BaseballPlayer b4 = new BaseballPlayer("팀1", "고씹석", "내야수", 4);
        players.add(b4);

        BaseballPlayer b5 = new BaseballPlayer("팀1", "고쎅석", "내야수", 5);
        players.add(b5);

        return players;
    }
}
