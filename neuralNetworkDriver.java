
public class neuralNetworkDriver {

	public static void main(String[] args) {
		
		
		neuralNetwork NN = new neuralNetwork(3);
		
		
		
		
		NN.setInput(0, 0.9);
		NN.setInput(1, 0.1);
		NN.setInput(2, 0.8);
		
		//TESTs
		NN.matrix_layers[0][0].weights[0] = 0.9;
		NN.matrix_layers[0][0].weights[1] = 0.2;
		NN.matrix_layers[0][0].weights[2] = 0.1;
		
		NN.matrix_layers[0][1].weights[0] = 0.3;
		NN.matrix_layers[0][1].weights[1] = 0.8;
		NN.matrix_layers[0][1].weights[2] = 0.5;
		
		NN.matrix_layers[0][2].weights[0] = 0.4;
		NN.matrix_layers[0][2].weights[1] = 0.2;
		NN.matrix_layers[0][2].weights[2] = 0.6;
		
		
		NN.matrix_layers[1][0].weights[0] = 0.3;
		NN.matrix_layers[1][0].weights[1] = 0.6;
		NN.matrix_layers[1][0].weights[2] = 0.8;
		
		NN.matrix_layers[1][1].weights[0] = 0.7;
		NN.matrix_layers[1][1].weights[1] = 0.5;
		NN.matrix_layers[1][1].weights[2] = 0.1;
		
		NN.matrix_layers[1][2].weights[0] = 0.5;
		NN.matrix_layers[1][2].weights[1] = 0.2;
		NN.matrix_layers[1][2].weights[2] = 0.9;
		
		
		
		
		
		NN.run();
		
		System.out.println("HEI");
		// TODO Auto-generated method stub

	}

}
