package project3_line.dispatching_start;

import project3_line.view.TeamView;

/**
 * ClassName: DispatchingSystemMain
 * Package: com.myself00.project3_line.dispatching_start
 * Description:
 * 调度系统入口方法
 *
 * @Author Administrator
 * @Create 2024/4/19 17:48
 * @Version 1.0
 */
public class DispatchingSystemMain {
    public static void main(String[] args) {
        TeamView teamView = new TeamView();
        teamView.enterMainMenu();
    }
}
