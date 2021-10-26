package com.application.aopdemo.aspect;

import com.application.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Order(2)
public class DemoLoggingAspect {

    // adding @Before advice

    // *** @Before() ***

    // this expression will consider any type of return type
    // ** Mentioning Modifier is optional
    // @Before("execution(* addAccount())")

    // this expression will consider any method that starts with 'add'
    // @Before("execution(void add*())")

    // this expression will consider any method that present in the Class
    // @Before("execution(void com.application.aopdemo.dao.AccountDAO.addAccount())")

    // this expression will consider method with 0 or any number of parameters
    // @Before("expression(void addCustomer(..))")

    // expression will match on package with any Class, any method and number of Arguments
    // @Before("execution(* com.application.aopdemo.dao.*.*(..))")

    // this expression will match with only Account Object as first param and can any no. of param after Acc Obj
    // @Before("execution(* add*(com.application.aopdemo.Account, ..))")


    // *** Point Cut *** -- for re-usability of same expression

//    @Pointcut("execution(* com.application.aopdemo.dao.*.*(..))")
//    private void forDAOPackage() {}

    // create a point cut for getter and setter methods
//    @Pointcut("execution(* com.application.aopdemo.dao.*.get*(..))")
//    private void getter() {}

//    @Pointcut("execution(* com.application.aopdemo.dao.*.set*(..))")
//    private void setter() {}

    // create pointCut : Include package and exclude setter and getter
//    @Pointcut("forDAOPackage() && !(getter() || setter())")
//    private void forDAOPackageNoGetterSetter() {}



    // *** Advices *** //

    // Combination of point cut expression ex:-
    // Inside @Before(),  we mention the pointcut expression
    @Before("com.application.aopdemo.aspect.PointCutComboExpressions.forDAOPackageNoGetterSetter()")
    public void beforeAddAccount(JoinPoint joinPoint) { // ** Advice #1 ** //

        System.out.println(" !--- Before in Add Account ---! ");

        // ** Join Points ** -- to use the method args and display the method signature

        // display the method signature
        MethodSignature methodSign = (MethodSignature) joinPoint.getSignature();

        System.out.println("Method sign : " + methodSign);

        // display method arguments

        // get the args
        Object[] args = joinPoint.getArgs();

        // loop through args
        for(Object tempArg: args) {

            System.out.println(tempArg);

            if(tempArg instanceof Account) {

                // downcast and print
                Account account = (Account) tempArg;

                System.out.println("account name : " + account.getName());
                System.out.println("account level : " + account.getLevel());

            }

        }

    }

    // ** @Order **

    // To execute these advices in order, we need to place them
    // in different aspects and annotate them with @Order

    // -- Moved to ApiAnalyticsAspect class

//    @Before("forDAOPackageNoGetterSetter()")
//    public void performAPIOperations() {
//        System.out.println(" !--- Before the Api Operations ---! ");
//    }

    // -- Moved to LogToCloudAspect class

//    @Before("forDAOPackageNoGetterSetter()")
//    public void logToCloud() {
//        System.out.println("!--- Before the Logging into cloud ---! ");
//    }


    // *** @AfterReturning() *** ///

    // @AfterReturning will be executed after
    // completion of Target Object Task
    @AfterReturning(
            pointcut = "execution(* com.application.aopdemo.dao.AccountDAO.findAccounts(..))",
            returning = "result")
    public void afterReturningFindAccount(
            JoinPoint joinPoint, List<Account> result) {

        String method = joinPoint.getSignature().toShortString();
        System.out.println(" !--- Executing @AfterReturning ---! " + method);

        // print the result
        System.out.println(" !--- result is : " + result + " ---! ");

    }

    // ** @AfterThrowing ** -- to handle exceptions

    @AfterThrowing(
            pointcut = "(execution(* com.application.aopdemo.dao.AccountDAO.findAccounts(..)))",
            throwing = "exc")
    public void afterThrowingFindAccount(
            JoinPoint joinPoint, Throwable exc
    ) {

        String method = joinPoint.getSignature().toShortString();
        System.out.println(" !--- Executing @AfterThrowing ---! " + method + " ---! ");

        // log the exception
        System.out.println(" !--- result is : " + exc + " ---! ");

    }

    // ** @After ** --

    @After("(execution(* com.application.aopdemo.dao.AccountDAO.findAccounts(..)))")
    public void afterFindAccount(JoinPoint joinPoint) {

        String method = joinPoint.getSignature().toShortString();
        System.out.println(" !--- Executing @After ---! " + method + " ---! ");

    }

    // *** @Around ***

    @Around("(execution(* com.application.aopdemo.service.*.getFortune(..)))")
    public Object aroundGetFortune(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        //
        String method = proceedingJoinPoint.getSignature().toShortString();
        System.out.println(" !--- Executing @After ---! " + method + " ---! ");

        // get timestamp
        long begin = System.currentTimeMillis();

        Object result = proceedingJoinPoint.proceed();

        long end = System.currentTimeMillis();

        long duration = end - begin;
        System.out.println("Time taken : " + duration / 1000 + " seconds");

        return result;
    }

}
