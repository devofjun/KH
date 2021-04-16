#include <Servo.h>
Servo servo_3;

void setup() {
  pinMode(A0, INPUT);
  servo_3.attach(10);
  Serial.begin(9600);
}

void loop() {
  int val = analogRead(A0);
  Serial.println(val);
  // 입력값(0~1023) 범위를 180~0 범위(각도)로 매핑
  int angle = map(val, 0, 1023, 180, 0);
  servo_3.write(angle);
  delay(10);
}
