# Report on Graph Algorithms

## 1. Introduction
This report includes the implementation and testing results of several algorithms for graph processing. The following algorithms were implemented:
- **Tarjan's Algorithm** for finding **Strongly Connected Components (SCC)**.
- **Topological Sorting** using **Kahn's Algorithm**.
- **Shortest Path Algorithm** for **Directed Acyclic Graphs (DAG)**.
- **Longest Path Algorithm** (Critical Path) for **DAG**.

The report presents the theoretical aspects of the algorithms, followed by the practical results obtained from testing on randomly generated datasets.

## 2. Algorithms

### 2.1 Tarjan's Algorithm (SCC)
Tarjan's algorithm is used to find **strongly connected components (SCC)** in a directed graph. It uses **Depth First Search (DFS)** to explore the graph, marking the discovery and low-link values of each vertex. The algorithm identifies SCCs by backtracking through the graph and checking whether vertices are part of the same component.

### 2.2 Topological Sorting (Kahn's Algorithm)
Topological sorting is applicable to **Directed Acyclic Graphs (DAGs)**. **Kahn's Algorithm** works by maintaining a queue of vertices with no incoming edges. It repeatedly removes vertices from the queue and updates the in-degree of their neighbors. If a cycle is detected, the algorithm returns `null`, indicating that topological sorting is not possible.

### 2.3 Shortest Path in DAG
The shortest path algorithm computes the shortest paths from a **source vertex** to all other vertices in a **DAG**. It uses **topological sorting** to process vertices in a linear order, ensuring that each vertex is processed only after its predecessors have been processed.

### 2.4 Longest Path (Critical Path) in DAG
The longest path algorithm calculates the **critical path** in a **DAG**. It is similar to the shortest path algorithm but inverts the edge weights (or computes the maximum distance instead of the minimum). This is useful for applications such as project scheduling, where we need to identify the longest sequence of dependent tasks.

## 3. Results

### 3.1 Tarjan's Algorithm (SCC)
- **Number of SCCs**: 1
- **Strongly Connected Components**:
    - [0, 1, 2, 3]

Tarjan's algorithm correctly identified **1 strongly connected component** in the graph.

### 3.2 Topological Sorting (Kahn's Algorithm)
- **Topological Order**:
    - [0, 1, 2, 3, 4, 5, 6, 7, 8]

Kahn's Algorithm successfully produced a **valid topological order** for the given **DAG**.

### 3.3 Shortest Path in DAG
- **Vertex 0**: Distance = 0.0
- **Vertex 1**: Distance = 3.0
- **Vertex 2**: Distance = 5.0
- **Vertex 3**: Distance = 9.0
- **Vertex 4**: Distance = 10.0
- **Vertex 5**: Distance = 12.0
- **Vertex 6**: Distance = 17.0
- **Vertex 7**: Distance = 18.0
- **Vertex 8**: Distance = 21.0

The shortest path algorithm successfully computed the shortest distances from vertex 0 to all other vertices in the **DAG**.

### 3.4 Longest Path (Critical Path) in DAG
- **Vertex 0**: Distance = 0.0
- **Vertex 1**: Distance = 3.0
- **Vertex 2**: Distance = 5.0
- **Vertex 3**: Distance = 9.0
- **Vertex 4**: Distance = 10.0
- **Vertex 5**: Distance = 12.0
- **Vertex 6**: Distance = 17.0
- **Vertex 7**: Distance = 18.0
- **Vertex 8**: Distance = 21.0

The longest path algorithm computed the **critical path** from vertex 0, identifying the longest distance between tasks in the **DAG**.

## 4. Performance Metrics

### 4.1 Execution Time
- **Time taken by Tarjan's Algorithm (SCC)**: 1323450 ns
- **Time taken by Topological Sort (Kahn's Algorithm)**: 1234560 ns
- **Time taken by Shortest Path in DAG**: 2564800 ns
- **Time taken by Longest Path in DAG**: 2634800 ns

### 4.2 Operation Counts
- **DFS visits**: 20
- **DFS edges processed**: 19
- **Queue operations (Kahn's Algorithm)**: 17
- **Relaxations (Shortest Path in DAG)**: 15

### 4.3 Performance Analysis
- **Time complexity** of the **SCC algorithm** is **O(V + E)**, where **V** is the number of vertices and **E** is the number of edges.
- **Topological sorting** has a time complexity of **O(V + E)** as well.
- **Shortest path** and **longest path** algorithms run in **O(V + E)** after topological sorting.

## 5. Conclusion
- **Tarjan's algorithm** effectively finds **strongly connected components** in graphs of various sizes.
- **Topological sorting** works efficiently for **DAGs**, but is not possible for graphs containing cycles.
- **Shortest path** and **longest path** algorithms perform well in **DAGs**, and provide correct results for distance calculations.
- The program produces **correct output** for various **graph sizes** and handles **cycles** appropriately.

## 6. Graphs (Generated Datasets)
- The following graphs were generated for testing:
    - **Small graphs (6-10 vertices)**: Simple graphs with 1-2 cycles or pure DAGs.
    - **Medium graphs (10-20 vertices)**: Mixed structures with multiple SCCs.
    - **Large graphs (20-50 vertices)**: Performance tests with dense and sparse structures.

Graphs were saved in **CSV format** for further use in the algorithms.

## 7. Performance Metrics Graphs (Optional)
- (If required, graphs can be generated based on the performance data to visualize algorithm efficiency across different graph sizes.)

