build-docs:
	rm -rf ./doc
	mkdir ./doc
	javadoc -d ./doc -author -public -tag param -tag precondition:a:"Precondition:" -tag postcondition:a:"Postcondition:" -tag note:a:"Note:" -tag return -tag throws -tag example:a:"Example:" IntArraySet.java

.PHONY: build-docs