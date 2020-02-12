# IntentionBook
## Spis treści
* [O aplikacji](#o-aplikacji)
* [Technologie](#technologie)
* [Działanie](#działanie)

## O aplikacji
Aplikacja ma na celu imitować księgę mszalną w której zapisywane są intencję Mszy Świętej. 	
## Technologie
Wykorzystane technologie
* IntelliJ IDEA
* Spring-Boot
* Sourcetree(git)
* Thymeleaf(Front-end)
* Trello (do zarządzania zadaniami)

## Działanie
Aplikacja posiada kilku użytkowników z czego każdy posiada swoją rolę:
* Proboszcz("Admin") np.: (superpriest/qwerty)
* Kaplan np.: (priest1/qwerty)
* Zakrystianin np.: (zakr1/qwerty)

W momencie wejścia na http://localhost:8080 użytkownikowi ukazuje się ekran z intencjami, oraz możliwością zalogowania się:
![Intencje](https://user-images.githubusercontent.com/23701808/74338849-3ad0ec80-4da3-11ea-8a8e-beb10b6f57d7.PNG)

Zaloguj przenosi na panel logowania:
![Panel logowania](https://user-images.githubusercontent.com/23701808/74338921-5a681500-4da3-11ea-80f5-4ea636abe044.PNG)

Panel dodania intencji:
![Dodanie intencji](https://user-images.githubusercontent.com/23701808/74339143-c21e6000-4da3-11ea-9fc3-6f73caf3d7d1.PNG)

Proboszcz jako Admin posiada szczególny dostęp do:
* http://localhost:8080/show-all-workers - wyświetlenie pełnych informacji na temat użytkowników
![Widok informacji](https://user-images.githubusercontent.com/23701808/74338360-52f43c00-4da2-11ea-87ce-b5ade8f26a1a.PNG)

Proboszcz, Kaplan, Zakrystianin posiadają dostęp do:
* http://localhost:8080 - wszystkie intencje
* http://localhost:8080/add-new-intention - dodanie nowej intencji
 
W momencie kiedy zabroniony jest dostęp ukazuje się ekran:
![Brak dostępu](https://user-images.githubusercontent.com/23701808/74339436-5b4d7680-4da4-11ea-98cf-7ef4103da0ce.PNG)

  


  

