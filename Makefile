.PHONY: default run clean

default: out src
	@javac -Xlint:unchecked -d out src/*.java
	@cd out; jar cfe Rpg.jar Rpg.Main Rpg/*.class

run: default
	@cd out; java Rpg.Main

clean:
	@rm -fR out


src:
	@mkdir src
out:
	@mkdir out
