
void setup() {
  pinMode(11, OUTPUT);
  pinMode(A0, INPUT);
  Serial.begin(9600);
}
void loop() {
  int bright = analogRead(A0);
  Serial.println(bright);
  int val = map(bright, 900, 1323, 255, 0);
  Serial.println(val);
  analogWrite(11, val*50);
  delay(10);
  
}
