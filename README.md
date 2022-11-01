# 모바일 프로그래밍 개인과제입니다

## 개발환경
- JAVA
- SDK: minSDK(31) compileSDK(32)
- Android 12
- IDE: Android Studio

## 액티비티

### activity_main
![image](https://user-images.githubusercontent.com/49757982/198883337-722f14e4-0c49-4ef9-8cd9-1246085ef710.png)


로그인 화면을 구현하였습니다.

- 특이사항
  - 아이디와 비밀번호를 입력하면 일치하는 경우 로그인이 가능합니다.
  - 전구 버튼을 누르면 비밀번호를 점자에서 텍스트로 변환하여 어떻게 입력하였는지 확인 할 수 있습니다.
  
  ![image](https://user-images.githubusercontent.com/49757982/198883416-824b8267-ddbd-44dc-86c4-c95000a0bca5.png) ![image](https://user-images.githubusercontent.com/49757982/198883408-df5d130f-1f75-42b6-a938-23af7aaecf87.png)

  - 회원 가입버튼을 누르면 회원가입 창으로 이동 할 수 있습니다.
  - 비회원으로 시작을 누르면 바로 상품을 확인 할 수 있습니다.
  
### second
![image](https://user-images.githubusercontent.com/49757982/198883467-8615954a-7e5a-4ebc-bb7b-ae8d552aadfe.png)

회원 가입창을 구현했습니다.

- 특이사항
  - 아이디 중복검사가 가능합니다. 가능 여부를 텍스트로 표시해 줍니다.
  
  ![image](https://user-images.githubusercontent.com/49757982/198883486-090b6423-0ff0-4850-89ed-c2cf7a033d89.png) ![image](https://user-images.githubusercontent.com/49757982/198883497-58c8b4fe-cff2-4ca3-b44f-2b41b8c4b131.png)


  - 전구 버튼을 누르면 비밀번호를 점자에서 텍스트로 변환하여 어떻게 입력 할 수 있는지 확인 할 수 있습니다.
  - 아이디 비밀번호 개인정보 약관 세가지 조건을 만족하면 회원가입이 완료되며 activity_main.xml로 이동합니다.
  
### third
![image](https://user-images.githubusercontent.com/49757982/198883517-b650665c-2140-4594-9642-b2fe17ba4c09.png)

상품창을 구현하였습니다.

- 특이사항
    - 리스트뷰에 어댑터에 연결된 상품 정보들이 나열됩니다.
    - 회원으로 로그인 했을 경우엔 회원정보를 볼 수 있는 버튼이 비회원으로 로그인 했을시엔 회원가입창으로 이동 할 수 있는 버튼을 구현했습니다. 각각 clientinfo.xml, register_request.xml을 팝업창 형태로 띄우도록 하였습니다.
    
    ![image](https://user-images.githubusercontent.com/49757982/198883530-3789aaff-d96d-4cdb-b257-69a0e85c827c.png) ![image](https://user-images.githubusercontent.com/49757982/198883548-6cbc40b1-27b8-419f-9c56-63b37de3f02e.png)


    
## 디테일
- 회원가입시 오류를 방지하기위해 중복검사를 2회 실시합니다. 중복 검사를 완료하고 아이디를 다른 텍스트로 바꿀 경우 가입버튼을 눌렀을때 대조하여 중복 가입을 방지하였습니다.
- 회원 정보 저장을 위하여 SharedPreference를 사용하였습니다. 키값은 아이디이고 비밀번호부터 이름,전화번호,주소를 JSON형태로 만든 후 문자열로 저장하여 필요할때 다시 JSON형태로 꺼내어 사용합니다.
- 회원가입시 비밀번호 입력을 하면 자동으로 특수문자,대문자의 유무를 판별합니다. 조건을 만족 할 경우 즉시 사용가능한 비밀번호 임을 텍스트로 표시하도록 하였습니다.

![image](https://user-images.githubusercontent.com/49757982/198883585-6bf29784-e35c-4ee9-9284-89d85b9f4c67.png) ![image](https://user-images.githubusercontent.com/49757982/198883596-87ccc320-b14b-4f0d-84fe-589fe830b6f6.png)


    
