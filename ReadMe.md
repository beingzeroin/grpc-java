https://codelabs.developers.google.com/codelabs/cloud-grpc-java/index.html#0
https://github.com/grpc/grpc-java



mvn archetype:generate -DgroupId=in.beingzero.grpc \
 -DartifactId=grpc-hello-world \
 -DarchetypeArtifactId=maven-archetype-quickstart \
 -DinteractiveMode=false




  <properties>
    <maven.compiler.source>1.8</maven.compiler.source>
    <maven.compiler.target>1.8</maven.compiler.target>
  </properties>


option java_multiple_files = true;


mvn -DskipTests package
mvn exec:java -Dexec.mainClass=in.beingzero.grpc.App -q
mvn exec:java -Dexec.mainClass=in.beingzero.grpc.server.GreetingServer -q
mvn -DskipTests package exec:java -Dexec.mainClass=in.beingzero.grpc.client.GreetingClient -q