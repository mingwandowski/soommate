# Soommate

## 1. Introduction

Soommate is a simple rent distribution system, mainly face to like 3 or 4 friends would like to rent an apartment together. Since there are different kinds of rooms like master bedroom with own restroom or small bedroom with a shared restroom, or even someone may live in the living room. And also different people have different budgets. There is always gonna be some problem that how to value each bedroom and which bedroom each of them should choose.

Actually this is one thing that bothered us when we moved into our present apartment so that comes out this application. The basic idea is that you can create a big "Room" with different actual "rooms" to be chosen. And since we have fixed the total price of the whole "Room", each tenant could value each room. In other words, they can give out the highest price they are willing to accept for each room. After all the tenants have finished their valuation, it will find the best combination with the highest total amount of price and averaged to everyone. So that everyone has their best choice of the room and a good price which is lower than their valuation.  

## 2. Technique

This full stack project uses Spring-SpringMVC-MyBatis framework, MySQL in the back-end. And basic JavaScript, HTML/CSS, JSP for the front-end. Utlizing Maven to manage the project, and [deployed on my own Raspberry Pi](http://71.69.162.72:27373/soommate/) as a mini web server. In order to avoid the unstable of my Raspberry Pi, there is another version which is much more stable version [deployed on AWS](http://52.53.150.120:8080/soommate/).

## 3. Demo account
There is a demo account for new users to see how it worked. 

* Room name: 225

* Password: 123

there are four users would like to share an apartment with 3 bedrooms and a livingroom. The total price is 3500. Here are their evaluations:

userName | room1Price | room2Price | room3Price | room4Price
---------|------------|------------|------------|-----------
rich tony | 1100 | 950 | 850 | 600
poor tom | 950 | 900 | 850 | 800
high cost-effective | 1050 | 900 | 850 | 700
arsenal | 1000 | 950 | 850 | 700

After sign in, click "Show Result!" to see the calculation result.

Thanks for reading this!
