package com.terzeron.java;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class JPAImpl {
    static EntityManagerFactory factory = null;
    static EntityManager em = null;

    static {
        factory = Persistence.createEntityManagerFactory("JPAImpl");
        em = factory.createEntityManager();
    }

    public static void main(String[] args) {
        String queryStr = "select * from mytable";
        Query query = em.createQuery(queryStr);
        try {
            Object object = query.getSingleResult();
            if (object instanceof Employee) {
                System.out.println("EmployeeID: " + ((Employee) object).getEmployeeId());
            } else if (object instanceof Phone) {
                System.out.println(
                        "PhoneID: " + ((Phone) object).getPhoneId() + " owned by the Employee: " + ((Phone) object).getEmployee().getEmployeeId());
            } else if (object instanceof DriverLicense) {
                System.out.println("DriverLicenseID: " + ((DriverLicense) object).getLicenseId() + " owned by the " + "Employee: " + ((DriverLicense) object).getEmployee().getEmployeeId());
            } else {
                System.out.println("Value Queried Is: " + object);
            }
        } catch (Exception e) {
            List<Object> objects = query.getResultList();
            for (Object object : objects) {
                if (object instanceof Employee) {
                    System.out.println("EmployeeID: " + ((Employee) object).getEmployeeId());
                } else if (object instanceof Phone) {
                    System.out.println(
                            "PhoneID: " + ((Phone) object).getPhoneId() + " owned by the Employee: " + ((Phone) object).getEmployee().getEmployeeId());
                } else if (object instanceof DriverLicense) {
                    System.out.println("DriverLicenseID: " + ((DriverLicense) object).getLicenseId() + " owned by " + "the" + " Employee " + ((DriverLicense) object).getEmployee().getEmployeeId());
                } else if (object instanceof Object[]) {
                    // loop over the array of objects
                    Object[] arrayObjects = (Object[]) object;

                    for (Object arrayObject : arrayObjects) {
                        if (arrayObject instanceof Employee) {
                            System.out.print("EmployeeID: " + ((Employee) arrayObject).getEmployeeId());
                        } else if (arrayObject instanceof Phone) {
                            System.out.print("PhoneID: " + ((Phone) arrayObject).getPhoneId() + " owned by the " +
                                    "Employee: " + ((Phone) arrayObject).getEmployee().getEmployeeId() + ": ");
                        } else if (arrayObject instanceof DriverLicense) {
                            System.out.print("DriverLicenseID: " + ((DriverLicense) arrayObject).getLicenseId() + " " + "owned by the Employee " + ((DriverLicense) arrayObject).getEmployee().getEmployeeId() + " ::");
                        } else {
                            System.out.print("Value Queried Is: " + arrayObject + ": ");
                        }
                    }
                    System.out.println("");
                } else {
                    System.out.println("Value Queried Is: " + object + ": ");
                }
            }
        }
    }
}
