1. Create two annotations for fields:
     @Ok - empty annotation
     @Ugly - with an integer parameter (default = 5)

2. Create a Data class, 5 fields (integer) and annotate in this way:
     - 2 fields @Ok,
     - 2 fields @Ugly 

3. Create a SaveData class to write information from the Data class to a file. We write it this way:
     - if the field is @Ok, then we write it as is
     - if the field is @Ugly, then it changes to random in the range (-k;k)
     - if there is no annotation, then we do not write it to the file, but output it to a log file

File format:
{
"field": "value"
...
"field": "value"
}

4. make the mode of writing Data to a file by key from args[ ] 
     - a means to finish writing
     -r means to rewrite
5. make a method of reading Data from json
