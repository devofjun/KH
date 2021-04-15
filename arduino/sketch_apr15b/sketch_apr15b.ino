int buzzer = 10;
int pin = 11;
//int notes[] = {262, 294, 330, 350, 392, 440, 494}; //C, D, E, F, G
 
int notes[] = {
  330, 294, 262, 294, 330,
  330, 330, 294, 294, 294,
  330, 330, 330, 330, 294,
  262, 294, 330, 330, 330,
  294, 294, 330, 294, 262
};
int arr[] = {
  75, 25, 50, 50, 50,
  50, 100, 50, 50, 100,
  50, 50, 100, 75, 25,
  50, 50, 50, 50, 100,
  50, 50, 75, 25, 200
};
int count = 0;
 
void setup() {
  pinMode(buzzer, OUTPUT); // 3번핀을 출력모드로 설정
  pinMode(pin, INPUT);
}
void loop() {
  // 떴다떴다비행기
  if(digitalRead(pin) == HIGH) {
    //digitalWrite(buzzer,HIGH);
    tone(buzzer,notes[count%25],arr[count%25]);
    delay(200);
    noTone(buzzer);
    count++;
  } else {
    //digitalWrite(buzzer,LOW);
  }
  
  /*도레미파솔라시
  if(digitalRead(pin) == HIGH) {
    //digitalWrite(buzzer,HIGH);
    tone(buzzer,notes[count%7],100);
    delay(200);
    noTone(buzzer);
    count++;
  } else {
    //digitalWrite(buzzer,LOW);
  }
  */
  /*
  for(int i=0; i<5; i++) {
    if(digitalRead(pins[i]) == HIGH){
     // 핀번호, 프리퀀시, 지속시간
     tone(buzzer, notes[i],100);
     delay(200);
     noTone(buzzer);
    }
  }
  */
}
 
