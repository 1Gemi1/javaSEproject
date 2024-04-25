package project3_line.service;

import project3_line.model.Architect;
import project3_line.model.Designer;
import project3_line.model.Employee;
import project3_line.model.Programmer;

import static project3_line.service.Status.BUSY;
import static project3_line.service.Status.VOCATION;

/**
 * ClassName: TeamService
 * Package: com.myself00.project3_line.service
 * Description:
 * 团队服务
 *
 * @Author Administrator
 * @Create 2024/4/19 21:47
 * @Version 1.0
 */
public class TeamService {
    private int counter = 1;
    private final int MAX_MEMBER = 5;
    private Programmer[] team = new Programmer[MAX_MEMBER];
    private int total = 0;

    public TeamService() {
    }

    public Programmer[] getTeam(){
        Programmer[] team = new Programmer[total];
        for (int i = 0; i < total; i++) {
            team[i] = this.team[i];
        }
        return team;
    }
    public Programmer getMember(int id){
        Programmer programmer = team[id];
        return programmer;
    }
    public void addMember(Employee e) throws TeamException{
        //System.out.println("------"+e.getClass().getSimpleName());
        //System.out.println(e instanceof Programmer);
        if (total >= MAX_MEMBER)
            throw new TeamException("成员已满，无法添加");
        if (!(e instanceof Programmer))
            throw new TeamException("该成员不是开发人员，无法添加");

        Programmer p = (Programmer)e;
        switch (p.getStatus()) {
            case BUSY    :throw new TeamException("该员工已是某团队成员");
            case VOCATION:throw new TeamException("该员正在休假，无法添加");
        }
        if (isExist(p))
            throw new TeamException("该员工已在本团队中");

        int numOfArch = 0, numOfDsgn = 0, numOfPrg = 0;
        for (int i = 0; i < total; i++) {
            if (team[i] instanceof Architect) numOfArch++;
            else if (team[i] instanceof Designer) numOfDsgn++;
            else if (team[i] instanceof Programmer) numOfPrg++;
        }
        if (p instanceof Architect) {
            if (numOfArch >= 1) throw new TeamException("团队中至多只能有一名架构师");
        } else if (p instanceof Designer) {
            if (numOfDsgn >= 2) throw new TeamException("团队中至多只能有两名设计师");
        } else if (p instanceof Programmer) {
            if (numOfPrg >= 3) throw new TeamException("团队中至多只能有三名程序员");
        }
        //e.setId(counter);
        p.setStatus(Status.BUSY);
        p.setMemberId(counter++);
        team[total++] = p;
    }
    public void removeMember(int memberId) throws TeamException{
        //找到指定memberId的员工，并删除
        int i = 0;
        for (; i < total; i++) {
            if(team[i].getMemberId() == memberId){
                team[i].setStatus(Status.FREE);
                break;
            }
        }
        //如果遍历一遍，都找不到，则报异常
        if (i == total)
            throw new TeamException("找不到该成员，无法删除");
        //后面的元素覆盖前面的元素
        for (int j = i + 1; j < total; j++) {
            team[j - 1] = team[j];
        }
        team[--total] = null;
    }

    private boolean isExist(Programmer p) {
        for (int i = 0; i < total; i++) {
            if (team[i].getId() == p.getId()) return true;
        }

        return false;
    }
}
