.PHONY: default run clean

default: out src
	@javac -Xlint:unchecked -d out src/*.java
	@cd out; jar cfe Rpg.jar Main *.class

run: default
	@cd out; java -jar Rpg.jar

clean:
	@rm -fR out


src:
	@mkdir src
out:
	@mkdir out
