Задача:
Написать сокет, который будет обрабатывать запросы на /chat
При получении сообщения сокет должен отправит это сообщение обратно.

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
запускает ваш сервер,
ждет пока "Server started",
подсоединяется к ws://localhost:8080/chat
отправляет сообщение и ждет ответа (5 секунд)

[Вернуться на главную страницу](../)
 