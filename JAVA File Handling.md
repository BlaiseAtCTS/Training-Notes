# File Handling
## Create File:
```
File file = new File("src/main/java/org/FileOps/text_file/file.txt");
file.createNewFile();
```

## FileInputStream:
```
byte[] arr =  fis.readAllBytes(); -> Bytes (a character can be 2 bytes or 3 bytes(other lang than english), depending on encoding (UTF)).
System.out.println(Arrays.toString(arr)); -> will return character numbers.
int i = 0;
while(i < arr.length) {
    System.out.print((char) arr[i]);
    i++;
}
```

## .txt:
### FileWriter, Write File:
```
FileWriter writer = new FileWriter(file); -> (file, true) will append to file.
writer.write("Hello World"); (or) append (both does the same)
```

### BufferedWriter:
It can be used along with other Writer to provide buffering.
When we use FileWriter, it does IO operation for each character, BufferedWriter stores string in a buffer and write the whole string to the file. It flushes to the file when buffer is full or manually flushed.
```
FileWriter writer = new FileWriter(file);
BufferedWriter bwriter = new BufferedWriter(writer);
bwriter.newLine(); -> method is not available in FileWriter.
```

### Reader Concepts:
mark() -> mark a point in the stream.
reset() -> reset to a mark or starting of the stream.

### FileReader:
Reads each character.
```
FileReader reader = new FileReader(file);
reader.read() -> points to the next character.
int c = reader.read();
while(c != -1) {
    sout((char) c);
    c = reader.read();
}
```

### BufferedReader:
Reads each line.
```
String line;
while ((line = breader.readLine()) != null) {
    System.out.println(line);
}
```

## .properties:
Properties class takes Input Stream.
```
Properties prop = new Properties();
FileInputStream fis = new FileInputStream("config.properties");
prop.load(fis)
int name = prop.getProperty("item-name");
```

## .json:
Read Json:
Mvn: json-simple (for light parsing)
Parsing: Converting one structured data into another.
```
JSONParser parser = new JSONParser(); -> to parse JSON to object.
Object obj = parser.parse(reader); -> takes FileReader as an argument and returns an Object.
JSONObject jsonObject = (JSONObject) obj;
jsonObject.get("name");
```

Mvn: jackson
```
ObjectMapper objectMapper = new ObjectMapper();
Person person = objectMapper.readValue(file, Person.class); -> map json to pojo class.
```

## Deserialization and Serialization:
Deserialization: Json -> Java Object
Serialization: Java Object -> Json

## TypeReference:
TypeReference<>() {} -> 