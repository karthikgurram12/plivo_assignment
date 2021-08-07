# plivo_assignment

Automated the Outbounding call from Caller to Calle.

The implemented script will perform the below steps:

1. It will launch the plivo Web SDK in browser (Automated for both chrome and firefox).
2. Performs the login with Caller Credentials.
3. Verify the Plivo HomePage using SIP UserName, Call Status and Call Button.
4. Open the New Tab using Javascript execute Script with windows.open('') method.
5. Navigate to the New Tab and Enters the plivo Web SDK URL in browser.
6. Performs the login with Callee Credentials in 2nd Tab.
7. Navigate back to Caller Tab.
8. Make an Outbound Call at Caller side.
9. Navigate to Callee Tab.
10. Answer the call.
11. Navigate to Caller Tab and Verify the Call Status (It should be Answered).
12. End the call at Caller side.
13. Teardown the two chrome Tabs.

To run the Test in Chrome, the configuration properties should be:
browser=chrome, 
applicationType=webdriver

Main Test method that covers above code will be in PlivoMakeCallFromCallerToCalle class and method name is makeCallUsingPlivoWebSDK

Technologies or Tools Used:
* Page Object Model and Page Factory
* Maven To add dependencies
* TestNG to support test annotations.
* selenium
* java
* Log4J for Logging purpose




