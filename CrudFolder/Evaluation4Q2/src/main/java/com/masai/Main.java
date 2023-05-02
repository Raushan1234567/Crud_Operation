package com.masai;
import java.util.*;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class Main {
	
	static EntityManagerFactory emf;
	
	static {
		emf=Persistence.createEntityManagerFactory("Raushan");
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		
		int c;
		do {
			System.out.println("1. Insert ");
			System.out.println("2. Print By Id ");
			System.out.println("3. print by date range ");
			System.out.println("4. update subcription by id");
			System.out.println("5. Change plan using Id ");
			System.out.println("6. Delete ");
			System.out.println("7. Find By plan");
			System.out.println("0. Exit ");
			
			
			c=sc.nextInt();
			switch(c) {
			case 1:
				AddUi(sc);
				break;
			case 6:
				deleteUi(sc);
				break;
			case 2:
				PrintUi(sc);
				break;
			case 3:
				PrintBydaterangeUi(sc);
				break;
			case 4:
				UpdateUi(sc);
				break;
			case 0:
			  System.out.println("Thanks Visit agin");
				break;
				default :
					System.out.println("Invalid Selection");
					break;
			}
			
			
			
		}while(c!=0);
		sc.close();
		

	}


	 static void UpdateUi(Scanner sc) {
		// TODO Auto-generated method stub
		 
		 EntityManager em=emf.createEntityManager();
		 
		 Subscription s=null;
		 System.out.println("Enter id");
			int id=sc.nextInt();
			System.out.println("Enter plan name");
			String name=sc.next();
		 s=em.find(Subscription.class, id);
		 
		 EntityTransaction et =em.getTransaction();

		 s.setPlan_name(name);
		 et.begin();
		 try {
		 em.merge(s);
		 System.out.println("Updated successfully");
		 }catch(IllegalArgumentException e)
		 {
			 System.out.println("Invalis subcription");
		 }
		 
		 finally {
		 et.commit();
		 em.close();
		 }
		
	}


	static void PrintBydaterangeUi(Scanner sc) {
		// TODO Auto-generated method stub
		 
		 EntityManager em=emf.createEntityManager();
		 Subscription s=null; 
		 System.out.println("Enter start date ");
			String std1=sc.next();
			System.out.println("Enter End date");
			String end1=sc.next();
			
			String q="select e from Subscription e where e.std1 :po and e.end :po2";
			
			Query p=em.createQuery(q);
			
			p.setParameter("po", std1);
			p.setParameter("po2", end1);
			
			List<Subscription> list =p.getResultList();
			
			list.forEach(System.out::println);
			em.close();
			
			
			
	}


	static void PrintUi(Scanner sc) {
		 EntityManager em=emf.createEntityManager();
			Subscription s=null; 
			System.out.println("Enter subcrption id");
			int id=sc.nextInt();
			
			s=em.find(Subscription.class, id);
			
			if(s==null) {
				System.out.println("Invalid Subcription id");
			}
			
			else {
				List<Subscription> p=new ArrayList<>();
				
				p.add(s);
				p.forEach(System.out::println);
				}
		 
		
	}


	private static void deleteUi(Scanner sc) {
		EntityManager em=emf.createEntityManager();
		Subscription s=null; 
		System.out.println("Enter subcrption id");
		int id=sc.nextInt();
		
		s=em.find(Subscription.class, id);
		
		if(s==null) {
			System.out.println("Invalid Subcription id");
		}
		EntityTransaction et=em.getTransaction();
		
		et.begin();
		try {
		em.remove(s);
		System.out.println("deleted successfully");
		}catch(Exception e) {
		System.out.println(e.getMessage());
		}
	
			et.commit();
		
		em.close();
				
		
	}


	static void AddUi(Scanner sc) {
		System.out.println("Enter plan name");
		String name=sc.next();
		System.out.println("Enter no of channels");
		int nch=sc.nextInt();
		System.out.println("Enter Monthly charger");
		double charges=sc.nextDouble();
		System.out.println("Enter start date ");
		String std1=sc.next();
		System.out.println("Enter End date");
		String end1=sc.next();
		
		Subscription a=new Subscription(name,nch,charges,std1,end1);
		
		EntityManager em=emf.createEntityManager();
		
		EntityTransaction et=em.getTransaction();
		
		et.begin();
		em.persist(a);
	
			et.commit();
		
		em.close();
		
		
	}

}
