#MEDLIFE
Milestones	(https://github.com/fssa-batch3/sec_a_ishwarya.sankar__corejava_project_2/milestones)



##ER DIAGRAM
[![HDDvqOP.png](https://iili.io/HDDvqOP.png)

### Attributes:  
- [ ] userId  
- [ ] email  
- [ ] password  
- [ ] name  
- [ ] phone number  
- [ ] type  
- [ ] isDeleted###



 Validations:  
- [ ] validateUser()  
- [ ] validateName()  
- [ ] validateEmail()  
- [ ] validatePassword()  
- [ ] validatePhonenumber()  
- [ ] validateDeleteUser()### Test:  
- [ ] testValidateUser()  
- [ ] testValidateEmail()  
- [ ] testValidatePassword()  
- [ ] testValidatePhonenumber()  
- [ ] testValidateName()### DAO:  
- [ ] createUser()  
- [ ] isEmailExists()### Service:  
- [ ] registerUser()###

 Test:  
- [ ] testRegistrationSuccess()  
- [ ] testRegistrationEmailEmpty()  
- [ ] testRegistrationphonenumer()  
- [ ] testRegistrationEmptyPassword()  
- [ ] testRegistrationNullPassword()  
- [ ] testRegistrationEmptyUsername()  
- [ ] testRegistrationNullUser()### Estimation  
- [ ] 6 hrs### 

Flow  

```mermaid  
flowchart TD
A[Start]  
B[Display Registration Form]  
C[User Fills out Form]  
D[Validate Input]  
E{Validation Successful?}  
F[Save User Data]  
G[Registration Successful]  
H[Display Error Messages]  
I[End]  
A --> B  
B --> C  
C --> D  
D --> E  
E -- Yes --> F  
F --> G  
E -- No --> H  
H --> B  
H --> I  
G --> I  
```
