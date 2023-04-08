# kllbillagentui
A Simple UI for KillBill backend
The KAUI provided by KillBill was not suiting me for the quick demo and usage while doing some feature testing of KillBill backend, hence created this simple UI.

To start this application
   - mvnw spring-boot:run  
   - To check whether it is running properly enter http://localhost:<port>/home in the browser and it should show admin.html as controlled in MainController.java 
   - This is assumed that the KillBill is running at the URL http://ip.ad.dr.ess:PORT which is configured in the application.properties config.urlBase=http://ip.ad.dr.ess:PORT. 
   The KillBill could be running any where. For this test I have been running the KillBill and MySql on the AWS. 
