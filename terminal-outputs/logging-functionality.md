# Logging Functionality

## host: djxmmx.net port: 17 --loglevel=INFO

```
(base) MacBook-Pro-8 Info314 % java TCPClient djxmmx.net 17 --loglevel=INFO
Apr 10, 2023 4:48:58 PM TCPClient main
INFO: Connected to server
Apr 10, 2023 4:48:58 PM TCPClient main
INFO: Output stream created
Apr 10, 2023 4:48:58 PM TCPClient main
INFO: Input stream created
"Been all around the world, ain't never met a girl, that could take the things that you been through.
 Never thought the day would come, when you would get up and run, and I would be out chasing you.
 Cuz ain't no where in the club I'd rather be, ain't no one in the club I'd rather see, than the girl of my dreams that made me be, so happy, but now so lonely..."
Apr 10, 2023 4:48:59 PM TCPClient main
INFO: Server connection closed
Apr 10, 2023 4:48:59 PM TCPClient main
INFO: Exiting program
```

## host: djxmmx.net port: 17 --loglevel=ALL

```
(base) MacBook-Pro-8 Info314 % java TCPClient djxmmx.net 17 --loglevel=ALL 
Apr 10, 2023 4:49:12 PM TCPClient main
INFO: Connected to server
Apr 10, 2023 4:49:12 PM TCPClient main
INFO: Output stream created
Apr 10, 2023 4:49:12 PM TCPClient lambda$main$0
FINE: Thread started
Apr 10, 2023 4:49:12 PM TCPClient main
INFO: Input stream created
"Don't push me cuz I'm close to the edge, I'm tryin' not to lose my head.
 It's like a jungle sometimes, it makes me wonder, how I keep from going under..."
Apr 10, 2023 4:49:12 PM TCPClient main
INFO: Server connection closed
Apr 10, 2023 4:49:12 PM TCPClient main
INFO: Exiting program
```

## host: djxmmx.net port: 17 --loglevel=OFF

```
(base) MacBook-Pro-8 Info314 % java TCPClient djxmmx.net 17 --loglevel=OFF
"Show me what its for, make me understand it.
 I've been crawling in the dark, looking for the answer.
 Is there something more, than what I've been handed.
 I've been crawling in the dark, looking for the answer..."
```

## host: tcpbin.com port: 17 --loglevel=ALL

```
(base) MacBook-Pro-8 Info314 % java TCPClient tcpbin.com 4242 one two three --loglevel=ALL
Apr 10, 2023 4:50:06 PM TCPClient main
INFO: Connected to server
Apr 10, 2023 4:50:06 PM TCPClient main
INFO: Output stream created
Apr 10, 2023 4:50:06 PM TCPClient main
INFO: Data sent to server: one two three
Apr 10, 2023 4:50:06 PM TCPClient lambda$main$0
FINE: Thread started
Apr 10, 2023 4:50:06 PM TCPClient main
INFO: Input stream created
one two three
hi
Apr 10, 2023 4:50:09 PM TCPClient lambda$main$0
INFO: Data sent to server: hi
hi
I can send more data to the server
Apr 10, 2023 4:50:22 PM TCPClient lambda$main$0
INFO: Data sent to server: I can send more data to the server
I can send more data to the server
Apr 10, 2023 4:51:22 PM TCPClient main
INFO: Server connection closed
Apr 10, 2023 4:51:22 PM TCPClient main
INFO: Exiting program
```
