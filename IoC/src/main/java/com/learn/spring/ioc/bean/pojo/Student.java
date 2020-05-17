package com.learn.spring.ioc.bean.pojo;

import lombok.extern.slf4j.Slf4j;

/**
 * @ClassName Student
 * @Description:ApplicationContext Bean容器初始化案例
 * @Author lfq
 * @Date 2020/5/17
 **/
@Slf4j
public class Student {
    private Integer studentId;
    private Double score;
    private Integer rank;

    public Student(Integer studentId, Double score, Integer rank) {
        this.studentId = studentId;
        this.score = score;
        this.rank = rank;
        log.info("student有参构造器被调用");
    }

    public Student() {
        log.info("student无参构造器被调用");
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
        log.info("setStudentId:{}", studentId);
    }

    public void setScore(Double score) {
        this.score = score;
        log.info("setScore:{}", score);
    }

    public void setRank(Integer rank) {
        this.rank = rank;
        log.info("setRank:{}", rank);
    }

    public void init() {
        log.info("student初始化方法被调用");
    }

    public void destroy() {
        log.info("student销毁方法被调用");
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Student{");
        sb.append("studentId=").append(studentId);
        sb.append(", score=").append(score);
        sb.append(", rank=").append(rank);
        sb.append('}');
        return sb.toString();
    }
}
