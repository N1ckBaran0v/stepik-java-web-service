Задача:
Написать сервер с двумя сервлетами:
SignUpServlet для обработки запросов на signup и
SignInServlet для обработки запросов на signin

Сервлеты должны слушать POST запросы с параметрами
login
password

При получении POST запроса на signup сервлет SignUpServlet должн запомнить логин и пароль в AccountService.
После этого польователь с таким логином считается зарегистрированным.
При получении POST запроса на signin, после регистрации, SignInServlet проверяет,
логин/пароль пользователя. Если пользователь уже зарегистрирован, север отвечает

Status code (200)
и текст страницы:
Authorized

если нет:
Status code (401)
текст страницы:
Unauthorized

Инструкция подготовки к локальной проверке:
Соберите сервер со всеми зависимостями на библиотеки в server.jar
Для этого запустите Maven projects/<Project name>/Plugins/assembly/assembly:single
либо assembly.sh (assembly.bat)

Скопируйте server.jar на уровень src и запустите
java -jar server.jar

В логах консоли вы должны увидеть сообщения о старте сервера.
Проверьте, что сервер отвечает на запросы браузера.

Инструкция подготовки к автоматической проверке:
Добавьте в лог сообщение "Server started". По появлению в логе этого сообщения тестирующая система пойдет, что к вашему серверу можно обращаться.
Соберите server.jar содержащий все библиотеки.

Во время проверки тестовая система запускает ваш сервер, ждет пока "Server started",
посылает POST запрос на
http://localhost:8080/signup
посылает POST запрос на
http://localhost:8080/signin
и проверяет, что в ответ пришла страница содержащая
Authorized

[Вернуться на главную страницу](../)
