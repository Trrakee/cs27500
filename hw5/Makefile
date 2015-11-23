build-docs:
	rm -rf ./doc
	mkdir ./doc
	javadoc -d ./doc -author -public -tag param -tag precondition:a:"Precondition:" -tag postcondition:a:"Postcondition:" -tag note:a:"Note:" -tag return -tag throws -tag example:a:"Example:" WeirdArray.java
	javadoc -d ./doc -author -public -tag param -tag precondition:a:"Precondition:" -tag postcondition:a:"Postcondition:" -tag note:a:"Note:" -tag return -tag throws -tag example:a:"Example:" WeirdIterator.java
	javadoc -d ./doc -author -public -tag param -tag precondition:a:"Precondition:" -tag postcondition:a:"Postcondition:" -tag note:a:"Note:" -tag return -tag throws -tag example:a:"Example:" WeirdIterator2.java

.PHONY: build-docs