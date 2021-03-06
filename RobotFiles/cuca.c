#pragma config(Sensor, S1,     light,          sensorLightActive)
#pragma config(Sensor, S4,     eyes,           sensorSONAR)
//*!!Code automatically generated by 'ROBOTC' configuration wizard               !!*//

#define NO_LIGHT			255
#define LOW_LIGHT			64
#define MEDIUM_LIGHT	35
#define HIGH_LIGHT	  20
#define WTF_SUNLIGHT	0

//#define dark < 15 - 0
//#define normallight > 40

#define NEAR_CRASH			64
#define WALL_ON_SIGHT		126
#define NOT_EVEN_CLOSE	255

int bright;

bool danger()
{
	if (SensorValue(eyes) <= 23 )
		return true;
	return false;
}

bool dark()
{
	if(SensorValue(light) < 10 )
		return true;
	return false;
}
void noQuieroChocar()
{
	motor[motorB]= 0;
	motor[motorA]= -50;
	wait1Msec(500);
	motor[motorB]= -10;
	motor[motorA]= 70;
}

// Cambiar direccion
void changeDirection()
{
	int turnDir = 0;// 0 = izquierda, 1 = no giro, 2 = derecha
	turnDir = random(2);
	if(turnDir == 0)
	{
		motor[motorB]= 0;
	}
	else if(turnDir == 2)
	{
		motor[motorA] = 0;
	}
	wait1Msec(200);
}

bool rumbofijo()
{
	int newbright = SensorValue(light);
	int delta = bright - newbright;

	if(delta > 0) //vamos bien
		return true;
	return false;
}

void cucarachear()
{
	writeDebugStreamLine("%d", SensorValue(light));
	writeDebugStreamLine("estoy cucaracheando");
	while(!dark())
	{
		if (danger()) noQuieroChocar();
		bright = SensorValue(light);
		wait1Msec(100);
		if(!rumbofijo())
		{
			if (danger()) noQuieroChocar();
			changeDirection();
		}
		motor[motorA] = 90;
		motor[motorB] = 90;
	}
}


// agusto en lo oscurito
void nocucarachear()
{
	writeDebugStreamLine("%d", SensorValue(light));
	writeDebugStreamLine("no cucaracheo");
	// danza de la cucuracha
	if (danger()) noQuieroChocar();
	motor[motorA] = 15;
	motor[motorB] = 25;
}

task main()
{
	int expectopatronum = 1; // Si tengo patrones :D


	while (true)
	{
		// light 1 = si detecta luz.
		wait1Msec(100);
		while(!dark()) cucarachear();
		writeDebugStreamLine("%d", SensorValue(eyes));
		while(dark()) nocucarachear();
	}
}
