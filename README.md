# product
Spring Boot project for vkart services
----------------------------------
Description
-------------------------------------------------
Provide services shopping site "vkart". 

Technology
------------------
This app is developed is java Spring Boot(REST) using maven.
This app is dependent on another project "Vkart".

Test Product
--------------
1. Install eclipse or spring tool suite.
2. Download this project in your system.
3. Import this project as maven project in eclipse/sts.
4. Import another project "vkart" in my same github account as maven project.
5. Run "product" project as spring boot app.
6. Run project "vkart" on server.
7. you can go to http://localhost:8080/vkart/ and navigate yourself to check various functionalities.

Rest Services
---------------------
1. "http://localhost:5000/searchproduct/<productname>"	
2. http://localhost:5000/searchproduct/deals
3. http://localhost:5000/searchproduct/<userid>/recommendations
4. http://localhost:5000/searchproduct/<productname>/details
5. http://localhost:5000/searchproduct/<userid>/cart
6. http://localhost:5000/searchproduct/searchcartseller/<sellername>
7. http://localhost:5000/searchproduct/<userid>/cartcount
8. http://localhost:5000/searchproduct/<userid>/orders
9. http://localhost:5000/searchproduct/<sellername>/sellerorders
10. http://localhost:5000/searchproduct/<userid>/orders/<orderid>/cancel
11. http://localhost:5000/searchproduct/<userid>/orders/<orderid>/deliver
12. http://localhost:5000/searchproduct/<userid>/orders/<orderid>/return
13. http://localhost:5000/searchproduct/<userid>/address/add
14. http://localhost:5000/searchproduct/<userid>/address/<addressid>
15. http://localhost:5000/searchproduct/<userid>/address/<addressid>/delete
16. http://localhost:5000/searchproduct/<userid>/address






