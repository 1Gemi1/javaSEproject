package project3_line.service;

import project3_line.model.Architect;
import project3_line.model.Designer;
import project3_line.model.Employee;
import project3_line.model.Programmer;
import project3_line.model.model_interface.Equipment;
import project3_line.model.model_interface.NoteBook;
import project3_line.model.model_interface.PC;
import project3_line.model.model_interface.Printer;

import static project3_line.service.Data.*;

/**
 * ClassName: NameListService
 * Package: com.myself00.project3_line.service
 * Description:
 * 成员列表服务
 * @Author Administrator
 * @Create 2024/4/19 21:46
 * @Version 1.0
 */
public class NameListService {
    private NameListService nameListService;
    private static  Employee[] employees = new Employee[Data.EMPLOYEES.length];

    public NameListService() {
        for (int i = 0; i < Data.EMPLOYEES.length; i++) {
            if (EMPLOYEE == (Integer.parseInt(Data.EMPLOYEES[i][0]))){
                addEmployee(i);
            }else if (PROGRAMMER == (Integer.parseInt(EMPLOYEES[i][0]))){
                addProgrammer(i);
            }else if (DESIGNER == (Integer.parseInt(Data.EMPLOYEES[i][0]))){
                addDesigner(i);
            }else if (ARCHITECT == (Integer.parseInt(Data.EMPLOYEES[i][0]))){
                addArchitect(i);
            }
        }
    }
    private static void addEmployee(int i){
        employees[i] = new Employee(Integer.parseInt(Data.EMPLOYEES[i][1]),Data.EMPLOYEES[i][2],
                Integer.parseInt(Data.EMPLOYEES[i][3]),Double.parseDouble(Data.EMPLOYEES[i][4]),Integer.parseInt(Data.EMPLOYEES[i][0]));
    }
    private static void addProgrammer(int i){
        employees[i] = new Programmer(Integer.parseInt(Data.EMPLOYEES[i][1]),Data.EMPLOYEES[i][2],
                Integer.parseInt(Data.EMPLOYEES[i][3]),Double.parseDouble(Data.EMPLOYEES[i][4]),
                Integer.parseInt(Data.EMPLOYEES[i][0]),returnEquipment(i)
                );
    }
    private static void addDesigner(int i){
        employees[i] = new Designer(Integer.parseInt(Data.EMPLOYEES[i][1]),Data.EMPLOYEES[i][2],
                Integer.parseInt(Data.EMPLOYEES[i][3]),Double.parseDouble(Data.EMPLOYEES[i][4])
                ,Integer.parseInt(Data.EMPLOYEES[i][0]),returnEquipment(i),
                Double.parseDouble(Data.EMPLOYEES[i][5]));
    }
    private static void addArchitect(int i){
        employees[i] = new Architect(Integer.parseInt(Data.EMPLOYEES[i][1]),Data.EMPLOYEES[i][2],
                Integer.parseInt(Data.EMPLOYEES[i][3]),Double.parseDouble(Data.EMPLOYEES[i][4])
                ,Integer.parseInt(Data.EMPLOYEES[i][0]),returnEquipment(i),
                Double.parseDouble(Data.EMPLOYEES[i][5]),Double.parseDouble(Data.EMPLOYEES[i][6]));
    }
    private static Equipment returnEquipment(int id){
        int equipmentNum = Integer.parseInt(EQUIPMENTS[id][0]);
        Equipment equipment;
        switch (equipmentNum){
            case PC:
                equipment = new PC(EQUIPMENTS[id][1],EQUIPMENTS[id][2]);

                break;
            case NOTEBOOK:
                equipment = new NoteBook(EQUIPMENTS[id][1],Double.parseDouble(EQUIPMENTS[id][2]));
                break;
            case PRINTER:
                equipment = new Printer(EQUIPMENTS[id][1],EQUIPMENTS[id][2]);
                break;
            default:
                System.out.println("请输入正确的设备号!");
                equipment = null;
        }
        return equipment;
    }

    public Employee[] getAllEmployees() {
        return employees;
    }

    public Employee getEmployee(int id) throws TeamException{
//        System.out.println("---");System.out.println("---"+id);
        for (int i = 0; i < employees.length; i++) {
            if(employees[i].getId() == id){
                return employees[i];
            }
        }
        throw new TeamException("该员工不存在");
    }


}
