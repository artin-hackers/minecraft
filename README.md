# Návod 

## Co je potřeba

Nainstalovaná Java 8, git. Obojí přístupné s konzole.
 

## Postup

1. naklonovat si projekt k sobě - spustit v konzoli příkaz:
   
   `git clone https://github.com/artin-hackers/minecraft.git`

2. spustit ve složce, kam se projekt stáhl (bude to složka `minecraft`):
 
    `gradlew.bat prepareServer` 
    
    čímž se stáhne a připraví Minecraft server s aktuální verzí

3. spustit ve složce `minecraft`:

    `gradlew.bat runServer` 
    
    čímž se spustí aktuální kód na Minecraft serveru

4. připojit se k serveru:
    
    - přidat server - v Minecraftu:
     
        Multiplayer > Add Server > jako IP adresu dát 127.0.0.1 a pojmenovat si server
        
    - připojit se a testovat :)
    
5. vývoj probíhá ve třídě: `src/main/java/cz/artin/hackers/HackersPlugin.java` 
    
    a v popisu pluginu: `src/main/resources/plugin.yml`

Jakub ss
