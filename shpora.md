194.67.84.100
tomcat
81hs;Dpswm


ssh - удаленный доступ к командной строке

ssh tomcat@194.67.84.100

scp - копирование на/из сервер файлов

scp server-sem.jar tomcat@194.67.84.100:/home/tomcat/students/enikeev/
scp lib/* tomcat@194.67.84.100:/home/tomcat/students/enikeev/lib/

putty 
winscp 

/tomcat/home/
/tomcat/home/students/lastname

mc - файловый менеджер

1. Создаем UDP server
2. Ориентируемся на работу в linux
3. Предусматриваем экспорт библиотек
4. Упаковываем приложение в jar, настраиваем манифест
5. Контролируем соответствие версий Java
6. Настраиваем логирование
7. Реализуем механизм обработки сигнала завершения от ОС


MANIFEST.MF

Manifest-Version: 1.0
Created-By: Своими собственными руками
Build-Jdk-Spec: 19
Class-Path: lib/jackson-databind-2.18.2.jar lib/jackson-annotations-2.18
.2.jar lib/jackson-core-2.18.2.jar lib/log4j-web-2.24.2.jar lib/log4j-a
pi-2.24.2.jar lib/log4j-core-2.24.2.jar
Main-Class: ru.itis.dis301.lab17.udpclietserver.UDPServer


Перехват сигнала завершения от ОС

Runtime.getRuntime().addShutdownHook(stopServerHook);


        <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-dependency-plugin</artifactId>
                <version>3.8.1</version>
                <executions>
                    <execution>
                        <id>copy-dependencies</id>
                        <phase>prepare-package</phase>
                        <goals>
                            <goal>copy-dependencies</goal>
                        </goals>
                        <configuration>
                            <outputDirectory>
                                lib
                            </outputDirectory>
                        </configuration>
                    </execution>
                </executions>
            </plugin>

            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-jar-plugin</artifactId>
                <version>3.4.2</version>
                <configuration>
                    <archive>
                        <manifest>
                            <addClasspath>true</addClasspath>
                            <classpathPrefix>lib/</classpathPrefix>
                            <mainClass>
                                ru.itis.dis301.lab17.udpclietserver.UDPServer
                            </mainClass>
                        </manifest>
                    </archive>
                </configuration>
            </plugin>

        </plugins>


byte[] IntToByteArray( int data ) {    
byte[] result = new byte[4];
result[0] = (byte) ((data & 0xFF000000) >> 24);
result[1] = (byte) ((data & 0x00FF0000) >> 16);
result[2] = (byte) ((data & 0x0000FF00) >> 8);
result[3] = (byte) ((data & 0x000000FF) >> 0);
return result;        
}

int byteToInt(byte[] bytes, int length) {
int val = 0;
for (int i = 0; i < length; i++) {
val=val<<8;
val=val|(bytes[i] & 0xFF);
}
return val;
}

