# plivo_assignment

**Config changes needed in Configuration.properties file:**

To run the Test in Chrome using plivo web sdk, the configuration properties should be:
**browser=chrome, 
applicationPlatform=web**

To run the Test in firefox using plivo web sdk, the configuration properties should be:
**browser=firefox, 
applicationPlatform=web**

To run the Test in android device using plivo android sdk, the configuration properties should be:
**applicationPlatform=android**

**The Result of the Automated Test Script for web sdk is as follows:**

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

**The Result of the Automated Test Script for android sdk is as follows:**

1. It will launch the android sdk in the mobile (if we are going to change the mobile, we have to change
   the capabilities).
2. Login with the caller credentials.
3. Verify plivo homepage
4. Make an Outbound Call to calle number
5. Verify it navigates to page where we should see speaker and call end option ( Not able to make a call from
   android app to callee so just verified whether it is navigating to other page or not.
6. end call at caller end.
7. Teardown the environment.


a. Automation Scripts are available in:
**Main Test methods that covers above code will be in PlivoMakeCallFromCallerToCalle class under src and method names are makeCallUsingPlivoWebSDK, makeCallUsingPlivoAndroidSDK**

b.	Logs for the automation suite: **available under result package**
c.	Result for the Test script: **available under result package**



**Technologies or Tools Used:**
* Page Object Model and Page Factory
* Maven To add dependencies
* TestNG to support test annotations.
* selenium
* java
* Log4J for Logging purpose
* Appium




