package project3_line.view;

import project3_line.model.Architect;
import project3_line.model.Designer;
import project3_line.model.Employee;
import project3_line.model.Programmer;
import project3_line.service.NameListService;
import project3_line.service.TeamException;
import project3_line.service.TeamService;

import static project3_line.service.Data.*;

/**
* ClassName: TeamView
* Package: com.myself00.project3_line.view
* Description:
*       视图类
* @Author Administrator
* @Create 2024/4/20 8:46
* @Version 1.0
*/public class TeamView {
    private NameListService listSvc = new NameListService();
    private TeamService teamSvc = new TeamService();

    private boolean[] booleans = new boolean[]{true,true};

    public void enterMainMenu(){

        boolean loopFlag = booleans[0];
        char key = 0;
        do {
            if (booleans[1]) {
                setView(1);
                listAllEmployee();
                setView(2);
            }
            operate();
            loopFlag = booleans[0];
        } while (loopFlag);

    }
    private void setView(int num){
        switch(num){
            case 1:
                drawBoundary(30);
                System.out.print("开发团队调度系统");
                drawBoundary(30);
                System.out.println();
                System.out.println("ID\t" + "姓名\t\t" + "年龄\t\t" + "工资\t\t\t" + "职位\t\t" +
                        "状态\t\t" + "奖金\t\t\t" + "股票\t\t" + "领用设备\t\t"  );
                break;
            case 2:
                drawBoundary(70);
                System.out.println();
                break;
            case 3:
                System.out.print("1-团队列表 ");
                System.out.print("2-添加团队成员 ");
                System.out.print("3-删除团队成员 ");
                System.out.print("4-退出 ");
                System.out.print("请选择1-4:");
                break;
            case 4:
                drawBoundary(30);
                System.out.print("团队成员列表");
                drawBoundary(30);
                System.out.println();
                System.out.println("TID/ID\t" + "姓名\t\t" + "年龄\t\t" + "工资\t\t\t" + "职位\t\t" + "奖金\t\t\t" + "股票\t\t");
                break;
            case 5:
                drawBoundary(30);
                System.out.print("添加成员");
                drawBoundary(30);
                System.out.println();
                System.out.print("请输入要添加员工的ID:");
                break;
            case 6:
                drawBoundary(30);
                System.out.print("删除成员");
                drawBoundary(30);
                System.out.println();
                System.out.print("请输入要删除员工的TID:");
                break;
        }

    }
    private  void drawBoundary(int num){
        for (int i = 0; i < num; i++) {
            System.out.print("-");
        }
    }
    private void listAllEmployee(){
        for (int i = 1; i <= listSvc.getAllEmployees().length; i++) {
            showEmployee(i,1);
        }
    }
    private void showEmployee(int id,int function){
        int jobNum;
        switch (function){
            case 1:
                Employee e = listSvc.getEmployee(id);
                jobNum = e.getJob();
                if(EMPLOYEE <= jobNum){
                    System.out.print(e.getId() + "\t");
                    System.out.print(e.getName() + "\t");
                    System.out.print(e.getAge() + "\t\t");
                    System.out.print(e.getSalary() + "\t\t");
                    System.out.print(e.getJob() + "\t\t");
                }
                if(PROGRAMMER <= jobNum){
                    Programmer p = (Programmer) e;
                    System.out.print(p.getStatus() + "\t");
                }
                if(DESIGNER <= jobNum){
                    Designer d = (Designer)e;
                    System.out.print(d.getBonus() + "\t\t");
                    if(ARCHITECT <= jobNum){
                        Architect a = (Architect)e;
                        System.out.print(a.getStock() + "\t");
                    }else {
                        System.out.print("\t\t");
                    }
                    System.out.print(d.getDevice().getDescription());
                }

                System.out.println();
                break;
            case 2:
                Programmer p = teamSvc.getMember(id);
                if(p != null ){
                    jobNum = p.getJob();
                    if(PROGRAMMER <= jobNum){
                        System.out.print(p.getMemberId() + "/" + p.getId());
                        System.out.print(String.format( "%8s" , p.getName() ) + "\t");
                        System.out.print(p.getAge() + "\t\t");
                        System.out.print(p.getSalary() + "\t\t");
                        System.out.print(p.getJob() + "\t\t");
                    }
                    if(DESIGNER <= jobNum){
                        Designer d = (Designer)p;
                        System.out.print(d.getBonus() + "\t\t");
                    }
                    if(ARCHITECT <= jobNum){
                        Architect a = (Architect)p;
                        System.out.print(a.getStock() + "\t\t");
                    }
                    System.out.println();
                }
                break;
        }

    }
    private void operate(){
        setView(3);
        int operate = TSUtility.readMenuSelection();
        if(operate == '1') {
            getTeam();
            booleans[1] = false;
        }
        else if (operate == '2') {
            addMember();
            booleans[1] = true;
        }
        else if (operate == '3') {
            deleteMember();
            booleans[1] = true;
        }
        else if (operate == '4') {
            //System.exit(0);
            System.out.print("确认是否退出(Y/N)：");
            char yn = TSUtility.readConfirmSelection();
            if (yn == 'Y') booleans[0] = false;
        }
    }

    private void getTeam(){
        setView(4);
        Programmer[] teams = teamSvc.getTeam();
        if(teams.length == 0)   System.out.println("开发团队目前没有成员！");
        else {
            for (int i = 0; i < teams.length; i++) {
                showEmployee(i,2);
            }
        }
        setView(2);
        //operate();
    }
    private void addMember(){
        setView(5);
        int id = TSUtility.readInt();
        System.out.print("确认是否添加(Y/N):");
        char c = TSUtility.readConfirmSelection();
        if('Y'== c){
            try {
                teamSvc.addMember(listSvc.getEmployee(id));
                System.out.println("添加成功");
            } catch (TeamException e) {
                System.out.print("添加失败，原因：" + e.getMessage());
            }
            System.out.println();
            TSUtility.readReturn();
            //getTeam();
        } else {
//            setView(3);
//            addMember();
        }
    }
    private void deleteMember(){
        setView(6);
        int mId = TSUtility.readInt();
        System.out.print("确认是否删除(Y/N):");
        char c = TSUtility.readConfirmSelection();
        if('Y'== c){
            //删除
            try {
                teamSvc.removeMember(mId);
                System.out.println("删除成功");
            } catch (TeamException e) {
                System.out.println("删除失败，原因：" + e.getMessage());
            }
            TSUtility.readReturn();
            //getTeam();
        } else {
//            setView(3);
//            deleteMember();
        }
    }
}
