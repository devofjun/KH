void setup() {
  // put your setup code here, to run once:
  pinMode(9, OUTPUT);
  pinMode(10, OUTPUT);
  pinMode(11, OUTPUT);
}

void loop() {//출력 0 255 입력 0 1024
  //Yellow #FFFF00
  analogWrite(9,random(0,255));
  analogWrite(10,random(0,120));
  analogWrite(11,random(0,120));
  delay(1000);
}
