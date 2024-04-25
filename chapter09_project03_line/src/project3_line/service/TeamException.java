package project3_line.service;

/**
 * ClassName: TeamException
 * Package: com.myself00.project3_line.service
 * Description:
 * 自定义异常
 *
 * @Author Administrator
 * @Create 2024/4/19 22:14
 * @Version 1.0
 */
public class TeamException extends RuntimeException{
    static final long serialVersionUID = 23423423433L;
    public TeamException() {
    }

    public TeamException(String message) {
        super(message);
    }
}
