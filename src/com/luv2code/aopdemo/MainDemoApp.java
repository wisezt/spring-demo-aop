package com.luv2code.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;

import java.util.List;

public class MainDemoApp {

    public static void main(String[] args) {
        // read spring config java class
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DemoConfig.class);


        // get the bean form spring container
        AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
        MembershipDAO theMembershipDAO =
                context.getBean("membershipDAO", MembershipDAO.class);

        try {
            List<Account> theAccounts = theAccountDAO.findAccounts();
        } catch (Exception
                 theExc

        ){
            System.out.println("===> get an Exception");
        }


//        System.out.println("Main Programin: " + theAccounts.toString());
//        System.out.println("---");


        // close the context
        context.close();
    }

}
