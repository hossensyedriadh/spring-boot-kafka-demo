## spring-boot-kafka-demo
<p>This repository demonstrates basic <a href="https://kafka.apache.org/" target="_blank">Apache Kafka</a> message producer 
and consumer applications built with Java and <a href="https://spring.io/projects/spring-boot" target="_blank">Spring Boot</a>.</p>
<hr>
<h3>Useful commands (for Windows):</h3>
<div style="margin-left: 5px">
<div style="border: 1px solid #bdbdbd; padding: 5px;">
<strong>Start up ZooKeeper:</strong><br>
<code>.\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties</code>
</div>
<br>
<div style="border: 1px solid #bdbdbd; padding: 5px;">
<strong>Start up Kafka:</strong><br>
<code>.\bin\windows\kafka-server-start.bat .\config\server.properties</code>
</div>
<br>
<div style="border: 1px solid #bdbdbd; padding: 5px;">
<strong>Create a Kafka topic:</strong><br>
<code>.\bin\windows\kafka-topics.bat --bootstrap-server localhost:9092 -topic <i>country</i> --create 
--partitions <i>2</i> --replication-factor <i>1</i></code>
</div>
<br>
<div style="border: 1px solid #bdbdbd; padding: 5px;">
<strong>List all topics:</strong><br>
<code>.\bin\windows\kafka-topics.bat --bootstrap-server localhost:9092 -topic --list</code>
</div>
<br>
<div style="border: 1px solid #bdbdbd; padding: 5px;">
<strong>View live message stream:<br></strong>
<code>.\bin\windows\kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic <i>country</i> --from-beginning</code>
</div>
</div>
<hr>
<div>
<p>After startup and configuration of Kafka, start the <strong>kafka-consumer</strong> application to listen and view the messages in the kafka topic, start the 
<strong>kafka-producer</strong> application to publish messages to the kafka topic.</p>
</div>
