Input:
	locations of n nodes with their coordinates
Job:
	create a network topology(undirected graph) with following properties:
		1. Contains all nodes
		2. Degree of each vertex is at least 3
		3. Diameter of the graph is at most 4(hop-distance)
		4. Total cost of the network topology is as low as possible by the total
		   geometric length of all links
Goal:
	Implement two different heuristic algorithm(it does not have to guarantee the exact optimum).
	Branch and Bound || Greedy Local Search
	

	The Program runs on randomly generated examples with both algorithms.Instances are created as follows:
		1.Pick n random points in the plane, this is done by generating random numbers in some range and taking them
		as coordinates of the points.
		2.Results of the experimental runs are represented graphically, show in a figure the positions of the nodes
		and the resulting network topology.
		 
	
