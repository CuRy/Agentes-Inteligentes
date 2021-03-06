#pragma config(Sensor, S1,     light,          sensorLightActive)
#pragma config(Sensor, S2,     light2,         sensorI2CHiTechnicColor)
#pragma config(Sensor, S4,     eyes,           sensorSONAR)
//*!!Code automatically generated by 'ROBOTC' configuration wizard               !!*//

void avanza()
{
	motor[motorA] = 20;
	motor[motorB] = 20;
}

void reversa()
{
	motor[motorA] = -30;
	motor[motorB] = -30;
}

void sacarVuelta()
{
	motor[motorA] = -30;
	motor[motorB] = 30;
}

void endereza()
{
	motor[motorA] = 30;
	motor[motorB] = -30;
}


void voyATopar()
{
	reversa();
	wait10Msec(70);
	sacarVuelta();
	wait10Msec(70);
	avanza();
	wait10Msec(50);
	endereza();
	wait10Msec(70);

}

task main()
{
	while(true)
	{
		writeDebugStreamLine("%d", SensorValue(eyes));

		if(SensorValue(eyes) <= 17)
		{

				voyATopar();
		}
		avanza();
	}

}
