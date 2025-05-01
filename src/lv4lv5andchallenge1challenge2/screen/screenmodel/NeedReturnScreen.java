package lv4lv5andchallenge1challenge2.screen.screenmodel;

/**
 * 반환값을 필요로 하는 화면의 상위 인터페이스
 */
public interface NeedReturnScreen extends ScreenEvent {
    int selectedScreen();   // 반환값이 필요한 선택화면
}
