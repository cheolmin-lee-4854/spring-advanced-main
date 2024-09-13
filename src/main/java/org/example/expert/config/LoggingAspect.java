package org.example.expert.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Before("execution(* org.example.expert.domain.comment.controller.CommentAdminController.deleteComment(..))")
    public void logBeforeDeleteComment(JoinPoint joinPoint) {
        long commentId = (long) joinPoint.getArgs()[0];
        System.out.println("Accessing Comment Delete API with commentId: " + commentId);
    }

    @Before("execution(* org.example.expert.domain.user.controller.UserAdminController.changeUserRole(..))")
    public void logBeforeChangeUserRole(JoinPoint joinPoint) {
        long userId = (long) joinPoint.getArgs()[0];
        System.out.println("Accessing User Role Change API with userId: " + userId);
    }

    @After("execution(* org.example.expert.domain.comment.controller.CommentAdminController.deleteComment(..))")
    public void logAfterDeleteComment(JoinPoint joinPoint) {
        long commentId = (long) joinPoint.getArgs()[0];
        System.out.println("Successfully accessed Comment Delete API with commentId: " + commentId);
    }

    @After("execution(* org.example.expert.domain.user.controller.UserAdminController.changeUserRole(..))")
    public void logAfterChangeUserRole(JoinPoint joinPoint) {
        long userId = (long) joinPoint.getArgs()[0];
        System.out.println("Successfully accessed User Role Change API with userId: " + userId);
    }
}