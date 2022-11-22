.PHONY: default run clean

default: out src
	@javac -Xlint:unchecked -d out src/*.java

run: default
	@cd out; java Main; cd ..

clean:
	@rm -fR out


src:
	@mkdir src
out:
	@mkdir out
