void setup() {
  pinMode(A0,INPUT);
  pinMode(9,OUTPUT);
  pinMode(10,OUTPUT);
  pinMode(11,OUTPUT);
  Serial.begin(9600);
}

void loop() {
  Serial.println(analogRead(A0));
  int a = analogRead(A0);
  if(a > 900) {
    digitalWrite(11,HIGH);
    digitalWrite(10,HIGH);
    digitalWrite(9,HIGH);
  } else if(a>600) {
    digitalWrite(11,LOW);
    digitalWrite(10,HIGH);
    digitalWrite(9,HIGH);
  } else if(a>300) {
    digitalWrite(11,LOW);
    digitalWrite(10,LOW);
    digitalWrite(9,HIGH);
  } else {
    digitalWrite(11,LOW);
    digitalWrite(10,LOW);
    digitalWrite(9,HIGH);
  }
}
