## Steps to run tests on EPAM Mobile Cloud 
- Paste your own API_KEY into cloudTest.properties
- Run Cloud iOS Web tests in command line: mvn clean test -P cloudWebiOS
- Run Cloud iOS Native tests in command line: mvn clean test -P cloudNativeiOS
- Run Cloud Android Native tests in command line: mvn clean test -P cloudNativeAndroid
- Run Cloud Android Web tests in command line: mvn clean test -P cloudWebAndroid

# Native test:
-  **RegistrationTest** - register new user, login and make sure you are on budget activity page

# Web test:
- **WebTest** - search 'EPAM' in Google and make sure that there is relevant result