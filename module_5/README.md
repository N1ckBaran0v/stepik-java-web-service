Задача:
Написать AccountServer, который будет содержать переменную "разрешенное количество пользователей на сервере" (usersLimit).
Задать значение этой переменной по умолчанию -- 10.

Написать сервлет, который будет обрабатывать запросы на /admin
При получении GET запроса возвращать значение usersLimit.
То есть, сразу после старта сервер на GET запрос на /admin вернет страницу:
10

Вывести значение usersLimit в JMX с именем:
Admin:type=AccountServerController.usersLimit
Сделать значение этой переменной изменяемым.

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

Во время проверки тестовая система:
запустит ваш сервер,
подождет пока "Server started",
проверит через JMX, что значение по умолчанию == 10
отправит запрос на /admin и проверит, что ответ == 10
изменит значение на какое-то число N (0 < N < Integer.MAX_VALUE)
проверит через JMX, что значение == N
отправит запрос на /admin и проверит, что ответ == N

[Вернуться на главную страницу](../)
 