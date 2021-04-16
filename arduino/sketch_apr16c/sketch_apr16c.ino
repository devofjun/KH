int num1[10][7] = {
  //A B C D E F G
  {0, 0, 0, 0, 0, 0, 1}, //0
  {1, 0, 0, 1, 1, 1, 1}, //1
  {0, 0, 1, 0, 0, 1, 0}, //2
  {0, 0, 0, 0, 1, 1, 0}, //3
  {1, 0, 0, 1, 1, 0, 0}, //4
  {0, 1, 0, 0, 1, 0, 0}, //5
  {0, 1, 0, 0, 0, 0, 0}, //6
  {0, 0, 0, 1, 1, 1, 1}, //7
  {0, 0, 0, 0, 0, 0, 0}, //8
  {0, 0, 0, 0, 1, 0, 0} //9
};

void setup() {
  // put your setup code here, to run once:
  for(int i=2; i<=8; i++){
    pinMode(i,OUTPUT);
  }
  Serial.begin(9600);
  Serial.println(sizeof(num1));
  Serial.println(sizeof(num1[0]));
  Serial.println(sizeof(num1[0][0]));
}

void loop() {
  // 14/2 = 7
  int len = sizeof(num1) / sizeof(num1[0]);
  int len2 = sizeof(num1[0]) / sizeof(num1[0][0]);
  for(int i=0; i<len; i++){
    for(int j=0; j<len2; j++) {
     digitalWrite(j+2,num1[i][j]); 
    }
    delay(1000);
  }
}
