
public class neuralNetwork {
	private int num_input;
	private double inputs[];
	private double outputs[];
	
	public Node[][] matrix_layers;
	
	private int node_size;
	private int matrix_size;
	
	public neuralNetwork(int num_input) {
		this.num_input = num_input;
		
		this.node_size = num_input;
		
		inputs = new double[num_input];//
		outputs = new double[num_input];//
		
		matrix_layers = new Node[num_input-1][num_input];
		
		matrix_size = num_input-1;
		
		
		for(int i=0; i<num_input-1; i++) {
			
			for(int j=0; j<num_input; j++) {
				
				matrix_layers[i][j] = new Node(num_input);

			}
		}
		//x = (input1*w1.1)+(input2*w1.2)+...
		//activate function y = 1/(1+e^-x)
	}
	
	public void run() {
		//matric
		
		//First input
		int weight_index = 0;
		int input_index = 0;
		
		for(int j=0; j<inputs.length*node_size; j++) {
			
			if(  j%inputs.length ==0 && j!=0 ) { weight_index++; }
			if( input_index%inputs.length==0 && input_index!=0 ) { input_index =0; }
			
			//System.out.println( matrix_layers[0][j%inputs.length].weights[weight_index] +" "+inputs[input_index] );
			matrix_layers[0][weight_index].sigmoid = matrix_layers[0][weight_index].sigmoid + matrix_layers[0][j%inputs.length].weights[weight_index] * inputs[input_index];
			input_index++;
		}
		
		for(int j=0; j<inputs.length; j++) {
			 matrix_layers[0][j].output = 1 / (1 +Math.exp(matrix_layers[0][j].sigmoid*-1) );
		}
		
		//After first layer
		weight_index = 0;
		input_index = 0;
		for(int i=1; i<matrix_size; i++) {
			
			for(int j=0; j<node_size*node_size; j++) {
				if(  j%node_size ==0 && j!=0 ) { weight_index++; }
				if( input_index%node_size==0 && input_index!=0 ) { input_index =0; }
				
				matrix_layers[i][weight_index].sigmoid = matrix_layers[i][weight_index].sigmoid + matrix_layers[i][j%node_size].weights[weight_index] * matrix_layers[i-1][input_index].output;
				input_index++;
			}
			for(int j=0; j<node_size; j++) {
				matrix_layers[i][j].output = 1 / (1 +Math.exp(matrix_layers[i][j].sigmoid*-1) );
			}
		}

	}//run
	
	public void backPropagation() {
		
	}

	public void setInput(int index, double input_value) {
		this.inputs[index] = input_value;
	}
	
	 class Node {
		 double sigmoid;
		 double output;

		 double weights[];
		Node(int num_input) {
			sigmoid = 0;
			output = 0;
			weights = new double[num_input];
			for(int i=0; i<num_input; i++) {
				weights[i] = Math.random();//between 0 and 1
			}
		}
	}

}//Class
