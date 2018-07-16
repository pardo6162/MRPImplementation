Rem Attribute VBA_ModuleType=VBADocumentModule
Option VBASupport 1
Dim numaq As Integer
Dim numac As Integer
Dim tiempo As Integer
Dim numat As Integer
Dim stock As Integer
Dim stocks As Integer
Dim lote As Integer
Dim lotes As Integer
Dim entrega As Integer
Dim entregas As Integer
Dim existencia As Integer
Dim existencias As Integer

Private Sub CommandButton1_Click()
    Cells.Select
    Selection.ClearContents
    Cells(2, 1) = "Máquinas"
    Cells(2, 2) = "Actividades"
    Cells(2, 3) = "Tiempo"
    Cells(2, 4) = "Material"
    Cells(2, 5) = "Inferior"
    Cells(2, 6) = "Superior"
    Cells(2, 7) = "Stock de seguridad"
    Cells(2, 8) = "Inferior"
    Cells(2, 9) = "Superior"
    Cells(2, 10) = "Tamaño de Lote"
    Cells(2, 11) = "Inferior"
    Cells(2, 12) = "Superior"
    Cells(2, 13) = "Tiempo de entrega"
    Cells(2, 14) = "Inferior"
    Cells(2, 15) = "Superior"
    Cells(2, 16) = "Disponible t-1"
    Cells(2, 17) = "Inferior"
    Cells(2, 18) = "Superior"
    Cells(2, 19) = "Inventario a la mano"
    Cells(2, 20) = "Inferior"
    Cells(2, 21) = "Superior"
    Cells(2, 22) = "Costo ordenar"
    Cells(2, 23) = "Inferior"
    Cells(2, 24) = "Superior"
    Cells(2, 25) = "Costo de mantener"
    Cells(2, 26) = "Inferior"
    Cells(2, 27) = "Superior"
    
End Sub

Private Sub CommandButton2_Click()
maquinas
End Sub

Private Sub CommandButton3_Click()
actividad
End Sub
Private Sub CommandButton4_Click()
material
End Sub

Private Sub CommandButton5_Click()
generalidades
End Sub

Private Sub CommandButton6_Click()
mantenimiento
End Sub
Private Sub CommandButton7_Click()
bruto
End Sub

Private Sub CommandButton8_Click()
mrp
End Sub
Private Sub CommandButton9_Click()
Timemaqu
End Sub
Private Sub CommandButton10_Click()
costos
End Sub


Sub maquinas()

	'número de maquinas
	numaq = Cells(1, 1)
	'número de actividades
	numac = Cells(1, 2)
	
	'generar la tabla 
	'************************************************
	For i = 1 To numaq
	Cells(4, i + 1) = i
	Next
	
	For i = 1 To numac
	Cells(i + 4, 1) = i
	Next
	'*************************************************
	'Asigna aleatoriamente la cantidad de actividades por maquina
	For i = 1 To numaq
		For j = 1 To numac
			Cells(4 + j, i + 1) = Int((numac - 0 + 1) * Rnd() + 0)
		Next
	Next
	
	ActiveSheet.Range("$B$5:$B$100").RemoveDuplicates Columns:=1, Header:=xlNo
	ActiveSheet.Range("$C$5:$C$100").RemoveDuplicates Columns:=1, Header:=xlNo
	ActiveSheet.Range("$D$5:$D$100").RemoveDuplicates Columns:=1, Header:=xlNo
	ActiveSheet.Range("$E$5:$E$100").RemoveDuplicates Columns:=1, Header:=xlNo
	ActiveSheet.Range("$F$5:$F$100").RemoveDuplicates Columns:=1, Header:=xlNo
	ActiveSheet.Range("$G$5:$G$100").RemoveDuplicates Columns:=1, Header:=xlNo
	ActiveSheet.Range("$H$5:$H$100").RemoveDuplicates Columns:=1, Header:=xlNo
	ActiveSheet.Range("$I$5:$I$100").RemoveDuplicates Columns:=1, Header:=xlNo
	ActiveSheet.Range("$J$5:$J$100").RemoveDuplicates Columns:=1, Header:=xlNo
	ActiveSheet.Range("$K$5:$K$100").RemoveDuplicates Columns:=1, Header:=xlNo
	ActiveSheet.Range("$L$5:$L$100").RemoveDuplicates Columns:=1, Header:=xlNo
	ActiveSheet.Range("$M$5:$M$100").RemoveDuplicates Columns:=1, Header:=xlNo
	ActiveSheet.Range("$N$5:$N$100").RemoveDuplicates Columns:=1, Header:=xlNo
	ActiveSheet.Range("$O$5:$O$100").RemoveDuplicates Columns:=1, Header:=xlNo
	ActiveSheet.Range("$P$5:$P$100").RemoveDuplicates Columns:=1, Header:=xlNo
	ActiveSheet.Range("$Q$5:$Q$100").RemoveDuplicates Columns:=1, Header:=xlNo
	ActiveSheet.Range("$R$5:$R$100").RemoveDuplicates Columns:=1, Header:=xlNo
	ActiveSheet.Range("$S$5:$S$100").RemoveDuplicates Columns:=1, Header:=xlNo
	ActiveSheet.Range("$T$5:$T$100").RemoveDuplicates Columns:=1, Header:=xlNo
	ActiveSheet.Range("$U$5:$U$100").RemoveDuplicates Columns:=1, Header:=xlNo
	ActiveSheet.Range("$V$5:$V$100").RemoveDuplicates Columns:=1, Header:=xlNo
	ActiveSheet.Range("$W$5:$W$100").RemoveDuplicates Columns:=1, Header:=xlNo
	ActiveSheet.Range("$X$5:$X$100").RemoveDuplicates Columns:=1, Header:=xlNo
	ActiveSheet.Range("$Y$5:$Y$100").RemoveDuplicates Columns:=1, Header:=xlNo
	ActiveSheet.Range("$Z$5:$BZ$100").RemoveDuplicates Columns:=1, Header:=xlNo
End Sub


Sub actividad()
	'número de maquinas
	numaq = Cells(1, 1)
	'número de actividades
	numac = Cells(1, 2)
	'número de periodos
	tiempo = Cells(1, 3)
	
	
	'asigna aleatoriamente a a cada periodo de una maquina una actividad 1 si se realiza 0 si no se realiza    
	For m = 1 To numaq
	    For i = 1 To tiempo
		    For j = 1 To numac
		   
		            Cells((m * (numac + 2)) + numaq + 2, 1) = "Máquina" & m
		            Cells((m * (numac + 2)) + numaq + j + 2, i + 1) = CInt((1 * Rnd() + 0))
		            Cells((m * (numac + 2)) + numaq + j + 2, 1) = j
		            Cells((m * (numac + 2)) + numaq + 2, i + 1) = i
		    Next
	    Next
	Next

End Sub


Sub material()
	'calcula la ultima fila llena
	ultif = Cells(Rows.Count, 1).End(xlUp).Row 'A1048576
	
	'número de actividades
	numac = Cells(1, 2)
	'número de materiales
	numat = Cells(1, 4)
	'material inferior
	minf = Cells(1, 5)
	'material superior
	msup = Cells(1, 6)

	'asigna aleatoreamente 
	For i = 1 To numat
	    For j = 1 To numac
	   
		    Cells(ultif + 2, 1) = "Actividades vs Materiales"
		    Cells(ultif + j + 2, i + 1) = Int((msup - minf + 1) * Rnd() + minf)
		    Cells(ultif + j + 2, 1) = j
		    Cells(ultif + 2, i + 1) = i
	    Next
	Next

End Sub

Sub generalidades()
	'ultima fila que ha sido llenada
	filult = Cells(Rows.Count, 1).End(xlUp).Row 'A1048576
	'Stock de seguridad inferior
	stock = Cells(1, 8)
	'Stock de seguridad superior
	stocks = Cells(1, 9)
	'Tamaño del lote inferior
	lote = Cells(1, 11)
	'Tamaño del lote superior
	lotes = Cells(1, 12)
	'Tiempo de entrega inferior 
	entrega = Cells(1, 14)
	'Tiempo de entrega superior
	entregas = Cells(1, 15)
	'Disponibilidad t-1 inferior
	existencia = Cells(1, 17)
	'Disponibilidad t-1 superior
	existencias = Cells(1, 18)
	'Inventario a la mano inferior
	mano = Cells(1, 20)
	'Invetario a la mano superior
	manos = Cells(1, 21)
	'Costo de ordenar inferior
	cosop = Cells(1, 23)
	'Costo de ordenar superior
	cosops = Cells(1, 24)
	'Costo de mantener  inferior
	cosmant = Cells(1, 26)
	'Costo de mantener superior
	cosmants = Cells(1, 27)

	For gg = 1 To numat

		Cells(filult + 2, 1) = "Generalidades"
		Cells(filult + 2, 2) = "Stock de seguridad"
		Cells(filult + 2, 3) = "Tamaño de lote"
		Cells(filult + 2, 4) = "Tiempo de entrega"
		Cells(filult + 2, 5) = "Disponible t-1"
		Cells(filult + 2, 6) = "Inventario a la mano"
		Cells(filult + 2, 7) = "Costo de ordenar"
		Cells(filult + 2, 8) = "Costo de mantenimiento"
		Cells(filult + 2, 9) = "Método de loteo"
		Cells(filult + 2, 10) = "Periodo"
		'Calcula número aleatorio de stock de seguridad entre el rango
		Cells(filult + gg + 2, 2) = Int((stocks - stock + 1) * Rnd() + stock)
		'Calcula el tamaño del lote aleatorio entre el rango
		Cells(filult + gg + 2, 3) = Int((lotes - lote + 1) * Rnd() + lote)
		'Calcula el tiempo de entrega aleatorio entre el rango
		Cells(filult + gg + 2, 4) = Int((entregas - entrega + 1) * Rnd() + entrega)
		'Calcula la Disponibilidad t-1 aleatorio entre el rango
		Cells(filult + gg + 2, 5) = Int((existencias - existencia + 1) * Rnd() + existencia)
		'Calcula el inventario a la mano aleatorio entre el rango
		Cells(filult + gg + 2, 6) = Int((manos - mano + 1) * Rnd() + mano)
		'Calcula el costo de ordenar aleatorio entre el rango
		Cells(filult + gg + 2, 7) = Int((cosops - cosop + 1) * Rnd() + cosop)
		'Calcula el costo de mantenimineto aleatorio entre el rango
		Cells(filult + gg + 2, 8) = Int((cosmants - cosmant + 1) * Rnd() + cosmant)

		Cells(filult + gg + 2, 9) = Int((8 - 0 + 1) * Rnd() + 0)
		Cells(filult + gg + 2, 10) = Int((8 - 0 + 1) * Rnd() + 0)
		Cells(filult + gg + 2, 1) = gg
	Next


End Sub


Sub mantenimiento()
	'Número de maquinas
	numaq = Sheets("E").Cells(1, 1)
	'Número de actividades
	numac = Sheets("E").Cells(1, 2)
	tiempo = Sheets("E").Cells(1, 3)
	Dim suma As Double
	  
	'El siguiente código es para hacer la matriz de requerimiento total de mantenimiento, solo los índices de indicación
	ufila = Cells(Rows.Count, 1).End(xlUp).Row 'A1048576

	'El siguiente código es para rellenar la matriz de requerimiento total de mantenimiento, con la sumatoria
	For y = 0 To tiempo
		Cells(ufila + 2, y + 1) = y
		Cells(ufila + 2, 1) = "Requerimiento total de mantenimiento"
	Next
		
	For Z = 1 To numac
		Cells(Z + (ufila + 2), 1) = Z
	Next
		
	
	'El objetivo de este codigo es encontrar cuantas veces por periodo se debe realizar cada actividad
	'por cada una de las maquinas    
	'por cada una de las maquinas que realiza la actividad se suma el periodo de tiempo en el qu e realiza para obtener la cantidad total de mantenimiento que se debe hacer
	For m = 1 To numaq
		'por cada actividad
		For i = 1 To numac
			'actev =4
			actev = Cells(4 + i, 1 + m)

			'Valor es la asignación de actividad a cada máquina
			buscardato = "Máquina" & m
			' Nrofila = 15 
			Range("a1").Select
			Cells.Find(What:=buscardato, After:=ActiveCell, LookIn:=xlValues, LookAt:=
				    xlPart, SearchOrder:=xlByRows, SearchDirection:=xlNext, MatchCase:=False 
				    , SearchFormat:=False).Activate
			Nrofila = ActiveCell.Row
			't=15			
			t = Nrofila
			'w=19
			w = t + actev
			'ceev=4
			ceev = Cells(w, 1)
			suma = 0
			    
			If actev = ceev Then
			    For a = 1 To tiempo
				suma = Cells(w, a + 1)
				Cells(ufila + 2 + actev, a + 1) = suma + Cells(ufila + 2 + actev, a + 1)
			    Next
				     
			'Como se evalúa por máquina, se requiere saber en qué fila comienza el número de máquina
			End If

		Next
	Next
End Sub

Sub bruto()

	numat = Sheets("E").Cells(1, 4)
	numac = Sheets("E").Cells(1, 2)
	tiempo = Sheets("E").Cells(1, 3)
	  
	'El siguiente código es para hacer la matriz de requerimiento total de mantenimiento, solo los índices de indicación
	uf = Cells(Rows.Count, 1).End(xlUp).Row 'A1048576
	'El siguiente código es para rellenar la matriz de requerimiento total de mantenimiento, con la sumatoria
	For yy = 0 To tiempo
		Cells(uf + 2, yy + 1) = yy
		Cells(uf + 2, 1) = "Requerimiento bruto de material"
	Next
		
	For Zz = 1 To numat
		Cells(Zz + (uf + 2), 1) = Zz
	Next
		
	sumaa = 0
	'Lo que se busca con esta función es definir la cantidad que se nececita de un material para cierto 
	'periodo de tiempo
	'por cada uno de los materiales
	For m = 1 To numat
		'en cada periodo de tiempo
		For t = 1 To tiempo
			sumaa = 0
			' se debe mirar por cada actividad
			For a = 1 To numac

				bact = "Actividades vs Materiales"
				Range("a1").Select
				Cells.Find(What:=bact, After:=ActiveCell, LookIn:=xlValues, LookAt:= _
		    			xlPart, SearchOrder:=xlByRows, SearchDirection:=xlNext, MatchCase:=False _
		    			, SearchFormat:=False).Activate
		    
				filan = ActiveCell.Row
				'cual es la cantidad de material m necesarioa en el tiempo t dada una actividad
				canmat = Cells(filan + a, m + 1)

				bmant = "Requerimiento total de mantenimiento"
				Range("a1").Select
		    		Cells.Find(What:=bmant, After:=ActiveCell, LookIn:=xlValues, LookAt:= _
		    			xlPart, SearchOrder:=xlByRows, SearchDirection:=xlNext, MatchCase:=False _
		    			, SearchFormat:=False).Activate
		    
				filmant = ActiveCell.Row
				
				cantiempo = Cells(filmant + a, t + 1)

				producto = canmat * cantiempo
				sumaa = sumaa + producto

				Cells(uf + 2 + m, t + 1) = sumaa

			Next
		Next
	Next

End Sub

Sub mrp()
	
	
	Dim timefin As Date
	Dim num1 As Double
	Dim num2 As Double
	Dim suma As Integer
	
	'Encontrar ultima fila que ha sido llenada
	fu = Cells(Rows.Count, 1).End(xlUp).Row 'A1048576

	'Cantidad de material
	numat = Cells(1, 4)
	'Cantidad de periodos
	tiempo = Cells(1, 3)
'Parte 1
'Completar la información basica del material
'**********************************************************************************************************************
	For t = 1 To tiempo
		For n = 1 To numat
			' Cantidad de variables definidas en las generalidades
			For gen = 2 To 10
				'Encontrar la fila donde estan las generalidades
				bgen = "Generalidades"
				Range("a1").Select
				Cells.Find(What:=bgen, After:=ActiveCell, LookIn:=xlValues, LookAt:= _
		    			xlPart, SearchOrder:=xlByRows, SearchDirection:=xlNext, MatchCase:=False _
		    			, SearchFormat:=False).Activate
		    		'**************************************************************************************
				filgen = ActiveCell.Row
				canmatgen = Cells(filgen + n, gen)

				Cells(fu + 2 + (n * 15), 1) = "Material"
				Cells(fu + 2 + (n * 15), gen) = Cells(filgen, gen)
				Cells(fu + 3 + (n * 15), gen) = canmatgen
				Cells(fu + 3 + (n * 15), 1) = "" & n

				Cells(fu + 4 + (n * 15), 1) = "Semanas"
				Cells(fu + 4 + (n * 15), t + 6) = t

				bcmat = "Requerimiento bruto de material"
				Range("a1").Select
		    		Cells.Find(What:=bcmat, After:=ActiveCell, LookIn:=xlValues, LookAt:= _
		    			xlPart, SearchOrder:=xlByRows, SearchDirection:=xlNext, MatchCase:=False _
		    			, SearchFormat:=False).Activate
		    
				filcmat = ActiveCell.Row
				canmatbru = Cells(filcmat + n, t + 1)

				Cells(fu + 5 + (n * 15), 1) = "Requerimiento bruto"
				Cells(fu + 5 + (n * 15), t + 6) = Cells(filcmat, t + 1)
				Cells(fu + 5 + (n * 15), t + 6) = canmatbru

				Cells(fu + 6 + (n * 15), 1) = "Inventario a la mano"
				Cells(fu + 6 + (n * 15), 6) = Cells(fu + 3 + (n * 15), 6)
				Cells(fu + 6 + (n * 15), t + 6).FormulaR1C1 = "=+RC[-1]+R[1]C+R[3]C-R[-1]C"

				Cells(fu + 7 + (n * 15), 1) = "Recepciones programadas"
				Cells(fu + 7 + (n * 15), 7) = Cells(fu + 3 + (n * 15), 5)


			Next
		Next
	Next

'Parte 2
'**********************************************************************************************************************
	'por cada uno de los materiales
	For n = 1 To numat
		For t = 1 To tiempo

			Cells(fu + 8 + (n * 15), 1) = "Requerimiento neto"
			'Si el inventario a la mano del periodo es menor igual al stock de seguridad se debe restar del 			stock de seguridad el inventario a la mano del periodo para saber cuanto se deberia pedir
	    		If Cells(fu + 6 + (n * 15), t + 6) <= Cells(fu + 3 + (n * 15), 2) Then
				Cells(fu + 8 + (n * 15), t + 6) = Cells(fu + 3 + (n * 15), 2) - Cells(fu + 6 + (n * 15), t + 6)
			Else
				Cells(fu + 8 + (n * 15), t + 6) = 0
	    		End If
		
			Cells(fu + 9 + (n * 15), 1) = "Recepciones planeadas"

			'Lote a lote
			If Cells(fu + 3 + (n * 15), 9) = 0 Then
				'Si el requerimiento neto en el periodo se puede dividir en el tamaño del lote
	    			If Cells(fu + 8 + (n * 15), t + 6) Mod Cells(fu + 3 + (n * 15), 3) = 0 Then
					Cells(fu + 9 + (n * 15), t + 6) = Cells(fu + 3 + (n * 15), 3) * ((Cells(fu + 8 + (n * 15), t + 6) / Cells(fu + 3 + (n * 15), 3) - (Cells(fu + 8 + (n * 15), t + 6) Mod Cells(fu + 3 + (n * 15), 3) / Cells(fu + 3 + (n * 15), 3))))
				Else
					Cells(fu + 9 + (n * 15), t + 6) = Cells(fu + 3 + (n * 15), 3) * ((Cells(fu + 8 + (n * 15), t + 6) / Cells(fu + 3 + (n * 15), 3)) - ((Cells(fu + 8 + (n * 15), t + 6) Mod (Cells(fu + 3 + (n * 15), 3)) / Cells(fu + 3 + (n * 15), 3)) + 1))
				End If

			'Cantidad fija de lo que necesito
			
	    
	    		ElseIf Cells(fu + 3 + (n * 15), 9) = 1 Then
				Cells(fu + 9 + (n * 15), t + 6) = Cells(fu + 8 + (n * 15), t + 6)
		
			'Periodo constante
	    		ElseIf Cells(fu + 3 + (n * 15), 9) = 2 Then
	    
				Z = Cells(fu + 3 + (n * 15), 10)
		
				If Cells(fu + 8 + (n * 15), t + 6) <> 0 Then
					Cells(fu + 9 + (n * 15), t + 6).Select
					ActiveCell.FormulaR1C1 = "=+SUM(R[-4]C:R[-4]C[" & Z - 1 & "])"
					sumaper = Cells(fu + 9 + (n * 15), t + 6)
		
					Cells(fu + 9 + (n * 15), t + 6).Select
					ActiveCell.FormulaR1C1 = "=+SUM(R[-2]C:R[-2]C[" & Z - 1 & "])"
					restaper = Cells(fu + 9 + (n * 15), t + 6)
		 
					Cells(fu + 9 + (n * 15), t + 6) = sumaper - (restaper) - Cells(fu + 6 + (n * 15), (t - 1) + 6) - Cells(fu + 3 + (n * 15), 2)
		
				Else
					Cells(fu + 9 + (n * 15), t + 6) = 0
				End If
			'EOQ
	    		ElseIf Cells(fu + 3 + (n * 15), 9) = 3 Then
	    
				Z = Cells(fu + 3 + (n * 15), 10)
				peri = Cells(1, 3)
				Cells(fu + 9 + (n * 15), 2).Select
				ActiveCell.FormulaR1C1 = "=+SUM(R[-4]C:R[-4]C[" & t + Z + 6 & "])"
				D = Cells(fu + 9 + (n * 15), 2)
				de = D / peri
				numq = (2 * de * Cells(fu + 3 + (n * 15), 7)) / Cells(fu + 3 + (n * 15), 8)
				Q = Sqr(numq)
				Qred = Round(Q, 0)
				Cells(fu + 9 + (n * 15), 3) = Qred
		
				If Cells(fu + 8 + (n * 15), t + 6) = 0 Then
		
					Cells(fu + 9 + (n * 15), t + 6) = 0
		
				Else
		        		Cells(fu + 9 + (n * 15), t + 6).Select
		        		ActiveCell.FormulaR1C1 = "=+ROUNDUP(R[-1]C/" & Qred & ",0)"
		        		vmult = Cells(fu + 9 + (n * 15), t + 6)
		        		Cells(fu + 9 + (n * 15), t + 6) = Qred * vmult
		        
				End If

		
	    
			'POQ
			'Tiene encuenta el periodo
	    		ElseIf Cells(fu + 3 + (n * 15), 9) = 4 Then
	    
				peri = Cells(1, 3)
		
				Cells(fu + 9 + (n * 15), 2).Select
				ActiveCell.FormulaR1C1 = "=+SUM(R[-4]C:R[-4]C[13])"
				D = Cells(fu + 9 + (n * 15), 2)
				de = D / peri
				numq = (2 * D * Cells(fu + 3 + (n * 15), 7)) / Cells(fu + 3 + (n * 15), 8)
				Q = Sqr(numq)
				Qred = Round(Q, 0)
		        
				Z = Cells(fu + 3 + (n * 15), 10)
		
				If Cells(fu + 8 + (n * 15), t + 6) <> 0 Then
		
					Cells(fu + 9 + (n * 15), t + 6).Select
					ActiveCell.FormulaR1C1 = "=+SUM(R[-4]C:R[-4]C[" & Z - 1 & "])"
					sumaper = Cells(fu + 9 + (n * 15), t + 6)
		
					Cells(fu + 9 + (n * 15), t + 6).Select
					ActiveCell.FormulaR1C1 = "=+SUM(R[-2]C:R[-2]C[" & Z - 1 & "])"
					restaper = Cells(fu + 9 + (n * 15), t + 6)
		 
					Cells(fu + 9 + (n * 15), t + 6) = Qred + sumaper - (restaper) - Cells(fu + 6 + (n * 15), (t - 1) + 6) - Cells(fu + 3 + (n * 15), 2)

				Else
					Cells(fu + 9 + (n * 15), t + 6) = 0
	    			End If
		
			'Balanceo de periodo fragmentado
	    		ElseIf Cells(fu + 3 + (n * 15), 9) = 5 Then
	    
				If Cells(fu + 8 + (n * 15), t	 + 6) <> 0 Then
		
					sumainv = 0
		    			ticost = Cells(1, 3).Value
		     			For Z = 0 To ticost - 1
		     				Sheets("E").Activate
		     				Sheets("E").Cells(fu + 9 + (n * 15), t + 6).Select
		     				ActiveCell.FormulaR1C1 = "=+SUM(R[-4]C:R[-4]C[" & Z & "])"
		     				requeri = Cells(fu + 9 + (n * 15), t + 6)
		     				inv1 = Cells(fu + 5 + (n * 15), t + 7)
		     				costoinve = Cells(fu + 3 + (n * 15), 7)
		     				costopedir = Cells(fu + 3 + (n * 15), 8)
		     
		     				sumainv = (inv1 * Z) + sumainv
						sumcostomant = costoinve * (sumainv)
						valorcomp = Abs(sumcostomant - costopedir)
						
						Sheets("C").Cells(Z + 1, 1).Value = valorcomp
						Sheets("C").Cells(Z + 1, 2).Value = requeri
						     
		     			Next Z
					Sheets("C").Activate
					ActiveSheet.Cells(1, 1).Select     
		          		zu = 1
		            		valor = Sheets("C").Cells(zu, 1).Value
		                	Do While valor <> "" And bin = 0
		                		If i = 1 Then
		                    			If valor < Sheets("C").Cells(zu + 1, 1).Value Then
		                        			primer_menor = valor
		                        			Valorinv = Sheets("C").Cells(zu, 2).Value
		                        			bin = 1
		                    			End If
		                		Else
		                    			If Sheets("C").Cells(zu, 1).Value >= valor And Sheets("C").Cells(zu + 1, 1).Value > valor Then
					                        primer_menor = valor
		                        			Valorinv = Sheets("C").Cells(zu, 2).Value
		                        			bin = 1
		                        
		                    			End If
		                		End If
		                
		                		zu = zu + 1
		                		valor = Sheets("C").Cells(zu, 1).Value
		                		Sheets("E").Cells(fu + 9 + (n * 15), t + 6).Value = Valorinv
		            		Loop
		      
		    			Sheets("C").Range("A1:C1000").Delete
		    			primer_menor = 0
		    
		    			Sheets("E").Activate
		    			ActiveSheet.Cells(1, 1).Select
		    			bin = 0
		    
				Else
					Cells(fu + 9 + (n * 15), t + 6) = 0
				End If
		
			'MCU (Mínimo coste unitario)
	    		ElseIf Cells(fu + 3 + (n * 15), 9) = 6 Then
	    
				If Cells(fu + 8 + (n * 15), t + 6) <> 0 Then
		
					sumainv = 0
			    		ticost = Cells(1, 3).Value
			    

				     	For Z = 0 To ticost - 1
					     	Sheets("E").Activate
					     	Sheets("E").Cells(fu + 9 + (n * 15), t + 6).Select
					     	ActiveCell.FormulaR1C1 = "=+SUM(R[-4]C:R[-4]C[" & Z & "])"
					     	requeri = Cells(fu + 9 + (n * 15), t + 6)
					     	inv1 = Cells(fu + 5 + (n * 15), t + 7)
					     	costoinve = Cells(fu + 3 + (n * 15), 7)
					     	costopedir = Cells(fu + 3 + (n * 15), 8)
					     
					     	sumainv = (inv1 * Z) + sumainv
					     	sumcostomant = costoinve * (sumainv)
					     	valorcomp = sumcostomant + costopedir
					   	costounitario = valorcomp / requeri
					     
					     	Sheets("C").Cells(Z + 1, 1).Value = costounitario
					     	Sheets("C").Cells(Z + 1, 2).Value = requeri
				     
				     	Next Z

				     	Sheets("C").Activate
				    	 ActiveSheet.Cells(1, 1).Select
			     
				  	zu = 1
				    	valor = Sheets("C").Cells(zu, 1).Value
				        Do While valor <> "" And bin = 0
				        	If i = 1 Then
				            		If valor < Sheets("C").Cells(zu + 1, 1).Value Then
				                		primer_menor = valor
								Valorinv = Sheets("C").Cells(zu, 2).Value
								bin = 1
				           		 End If
				      	  	Else
		                    			If Sheets("C").Cells(zu, 1).Value >= valor And Sheets("C").Cells(zu + 1, 1).Value > valor Then
		                        			primer_menor = valor
								Valorinv = Sheets("C").Cells(zu, 2).Value
								bin = 1
		                        
		                    			End If
		               			End If
		                
		                		zu = zu + 1
		               			valor = Sheets("C").Cells(zu, 1).Value
		                		Sheets("E").Cells(fu + 9 + (n * 15), t + 6).Value = Valorinv
		           		Loop
		      
		    			Sheets("C").Range("A1:C1000").Delete
		   	 		primer_menor = 0
		    
					Sheets("E").Activate
		     			bin = 0
		    
				Else
					Cells(fu + 9 + (n * 15), t + 6) = 0
				End If
		
			' Silver - Meal
	  		ElseIf Cells(fu + 3 + (n * 15), 9) = 7 Then
	    
				If Cells(fu + 8 + (n * 15), t + 6) <> 0 Then
		
					sumainv = 0
					contperi = 0
					ticost = Cells(1, 3).Value
		    

				     	For Z = 0 To ticost - 1
					     Sheets("E").Activate
					     Sheets("E").Cells(fu + 9 + (n * 15), t + 6).Select
					     ActiveCell.FormulaR1C1 = "=+SUM(R[-4]C:R[-4]C[" & Z & "])"
					     requeri = Cells(fu + 9 + (n * 15), t + 6)
					     inv1 = Cells(fu + 5 + (n * 15), t + 7)
					     costoinve = Cells(fu + 3 + (n * 15), 8)
					     costopedir = Cells(fu + 3 + (n * 15), 7)
					     
					     contperi = 1 + contperi
					     
					     sumainv = (inv1 * Z) + sumainv
					     sumcostomant = costoinve * (sumainv)
					     valorcomp = sumcostomant + costopedir
					     costounitario = valorcomp / contperi
					     
					     Sheets("C").Cells(Z + 1, 1).Value = costounitario
					     Sheets("C").Cells(Z + 1, 2).Value = requeri
				     
				     	Next Z

					Sheets("C").Activate
					ActiveSheet.Cells(1, 1).Select
					     
		          		zu = 1
		            		valor = Sheets("C").Cells(zu, 1).Value
		                	Do While valor <> "" And bin = 0
		                		If i = 1 Then
		                    			If valor < Sheets("C").Cells(zu + 1, 1).Value Then
		                        			primer_menor = valor
		                        			Valorinv = Sheets("C").Cells(zu, 2).Value
		                        			bin = 1
		                    			End If
		                		Else
		                    			If Sheets("C").Cells(zu, 1).Value >= valor And Sheets("C").Cells(zu + 1, 1).Value > valor Then
		                        			primer_menor = valor
		                       				Valorinv = Sheets("C").Cells(zu, 2).Value
		                        			bin = 1
		                        
		                    			End If
		                		End If
		                
		                		zu = zu + 1
		                		valor = Sheets("C").Cells(zu, 1).Value
		                		Sheets("E").Cells(fu + 9 + (n * 15), t + 6).Value = Valorinv
		           	 	Loop
		      
		    			Sheets("C").Range("A1:C1000").Delete
		    			primer_menor = 0
		    
		    			Sheets("E").Activate
		     			bin = 0
		    
				Else
					Cells(fu + 9 + (n * 15), t + 6) = 0
				End If
		
			' Wagner Whitin
			'Costo 1 = Costo menor del periodo anterior + el costo de ordenar en el periodo actual
			'Costo 2 = costo 1 del periodo anterior mas el costo de llevar inventario en el periodo actual
			'Costo 3= Segundo menor costo de dos periodos atrás + costo de llevar inventario del periodo anterior + 2 veces de llevar inventario en el periodo actual

	   		ElseIf Cells(fu + 3 + (n * 15), 9) = 8 Then
	      
				If Cells(fu + 8 + (n * 15), t + 6) <> 0 Then
					Sheets("C").Activate
					ActiveSheet.Cells(1, 1).Select
					costopedir = Sheets("E").Cells(fu + 3 + (n * 15), 7)
					costoinve = Sheets("E").Cells(fu + 3 + (n * 15), 8)
					valor = costopedir / costoinve
				      
					lt1 = Sheets("E").Cells(1, 3)
		
					For lt = 1 To lt1
		
						If Cells(fu + 5 + (n * 15), t + 6) <= valor Then
				
							Sheets("C").Cells(1, lt + 1).Value = Sheets("E").Cells(fu + 5 + (n * 15), t + 6)
							t = t + 1
						Else
		
							lt = lt1
						End If
		
					Next
				    
				   	For mes = 1 To t - 1
				    
					    	Sheets("C").Cells(2, mes + 1).Value = mes
					    	Sheets("C").Cells(t + 2, mes).Select
					    	ActiveCell.FormulaR1C1 = "=+MIN(R[" & -t + 1 & "]C:R[-1]C)"
		
						For alt = 0 To mes - 1
					    
							If alt = mes - 1 Then
								sumaN = 0
								For numma = 0 To alt
									sumaN = (Sheets("C").Cells(1, numma + 2).Value * (numma + 1 - 1) * costoinve) + sumaN
									Sheets("C").Cells(alt + 3, mes + 1).Value = costopedir + sumaN
								Next
				
							ElseIf alt = 0 And mes = alt + mes Then
				
								menori = Sheets("C").Cells(t + 2, mes - alt).Value
					
								Sheets("C").Cells(alt + 3, mes + 1).Value = menori + costopedir
		
							ElseIf alt > 0 And alt <> mes Then
				
								Sheets("C").Cells(alt + 3, mes + 1).Select
								ActiveCell.FormulaR1C1 = "=+R[-1]C[-1]"
				
								funcio = Sheets("C").Cells(alt + 3, mes + 1).Value
				
								ValorR = funcio + (Sheets("C").Cells(1, mes + 1).Value * costoinve * (alt))
						 
								Sheets("C").Cells(alt + 3, mes + 1).Value = ValorR
								                              
							End If
						Next
		
			    		Next
			    
			    		Sheets("C").Cells(t + 2, mes).Select
			    		ActiveCell.FormulaR1C1 = "=+MIN(R[" & -t + 1 & "]C:R[-1]C)"
			    		valorulmes = Sheets("C").Cells(mes + 2, mes).Value
						               
			    
			    		lapicero = 1
			    		alt = 1
			    		mesreal = t - 1
			    
			    		If lapicero <> 0 Then
			       			For alt = alt To mes - 1
			       
							valormenosr = Sheets("C").Cells(mesreal + 3, mes).Value
							ultvalor = Sheets("C").Cells(alt + 2, mes).Value
								 
							If valormenosr = ultvalor And alt = mes - 1 Then
							    Sheets("C").Cells(mesreal + 4, 2).Select
							    ActiveCell.FormulaR1C1 = "=+SUM(R[" & -mesreal - 3 & "]C:R[" & -mesreal - 3 & "]C[" & mes - (mes - alt) - 1 & "])"
							    Valormrp = Sheets("C").Cells(mes + 4, um + 1).Value
							    Sheets("E").Cells(fu + 9 + (n * 15), t + 6 - mes + 1).Value = Valormrp
							    lapicero = 0
								     
							ElseIf valormenosr = ultvalor And alt <> mes - 1 Then
							    mesult = mes - 1
							    Sheets("C").Cells(mesreal + 4, mes - alt + 1).Select
							    ActiveCell.FormulaR1C1 = "=+SUM(R[" & -mes - 2 & "]C:R[" & -mes - 2 & "]C[" & mes - (mes - alt) - 1 & "])"
							    Valormrp1 = Sheets("C").Cells(mes + 4, alt + 1).Value
							    mes = mesreal - alt + 1
							    lapicero = 1
							    alt = 1
							End If
				 		Next
			    		End If
			       
				
				Else
					Cells(fu + 9 + (n * 15), t + 6) = 0
				End If
			End If



			Cells(fu + 10 + (n * 15), 1) = "Orden liberada"
			te = Cells(fu + 3 + (n * 15), 4)
			Cells(fu + 10 + (n * 15), t + 6 - te) = Cells(fu + 9 + (n * 15), t + 6)

		Next
	Next

End Sub

Sub costos()


numat = Cells(1, 4)
tiempo = Cells(1, 3)

For t = 1 To tiempo
For n = 1 To numat

Cells(fu + 11 + (n * 15), 1) = "Costo de mantener"
Cells(fu + 11 + (n * 15), t + 6) = Cells(fu + 3 + (n * 15), 7) * Cells(fu + 6 + (n * 15), t + 6)


Cells(fu + 12 + (n * 15), 1) = "Costo de ordenar"
te = Cells(fu + 3 + (n * 15), 4)
Cells(fu + 12 + (n * 15), t + 6) = Cells(fu + 9 + (n * 15), t + 6) * Cells(fu + 3 + (n * 15), 8)


For i = 1 To tiempo + 6
Cells(fu + 13 + (n * 15), 1) = "Costos totales"
Cells(fu + 13 + (n * 15), i) = "=+R[-1]C+R[-2]C"
Cells(fu + 13 + (n * 15), t + 7) = "=+SUM(RC[-8]:RC[-1])"
Next

Next
Next

End Sub

Sub Timemaqu()

Dim timein As Date
Dim timefin As Date
Dim cont As Integer

cont = 1

For m = 1 To 5
For a = 1 To 5
For t = 1 To 3
'For ma = 1 To 10
'For mai = 1 To 10
For mas = 1 To 5
'For ssi = 1 To 10
'For sss = 1 To 10
'For tli = 1 To 10
'For tls = 1 To 10
'For tei = 1 To 10
'For tes = 1 To 10
'For di = 1 To 10
'For ds = 1 To 10
'For imi = 1 To 10
'For ims = 1 To 10


timein = Now
Sheets("T").Cells(cont + 1, 7) = timein

Sheets("E").Cells(1, 1) = m * 10
Sheets("E").Cells(1, 2) = a * 20
Sheets("E").Cells(1, 3) = t * 10
Sheets("E").Cells(1, 4) = 0
Sheets("E").Cells(1, 5) = 1
Sheets("E").Cells(1, 6) = mas * 25
Sheets("E").Cells(1, 7) = 0
Sheets("E").Cells(1, 8) = 1
Sheets("E").Cells(1, 9) = 5
Sheets("E").Cells(1, 10) = 0
Sheets("E").Cells(1, 11) = 1
Sheets("E").Cells(1, 12) = 5
Sheets("E").Cells(1, 13) = 0
Sheets("E").Cells(1, 14) = 1
Sheets("E").Cells(1, 15) = 4
Sheets("E").Cells(1, 16) = 0
Sheets("E").Cells(1, 17) = 1
Sheets("E").Cells(1, 18) = 60
Sheets("E").Cells(1, 19) = 0
Sheets("E").Cells(1, 20) = 1
Sheets("E").Cells(1, 21) = 30

Sheets("T").Cells(1, 1) = Sheets("E").Cells(2, 1)
Sheets("T").Cells(1, 2) = Sheets("E").Cells(2, 2)
Sheets("T").Cells(1, 3) = Sheets("E").Cells(2, 3)
Sheets("T").Cells(1, 4) = Sheets("E").Cells(2, 4)
Sheets("T").Cells(1, 5) = Sheets("E").Cells(2, 5)
Sheets("T").Cells(1, 6) = Sheets("E").Cells(2, 6)
'Sheets("T").Cells(1, 7) = Sheets("E").Cells(2, 7)
'Sheets("T").Cells(1, 8) = Sheets("E").Cells(2, 8)
'Sheets("T").Cells(1, 9) = Sheets("E").Cells(2, 9)
'Sheets("T").Cells(1, 10) = Sheets("E").Cells(2, 10)
'Sheets("T").Cells(1, 11) = Sheets("E").Cells(2, 11)
'Sheets("T").Cells(1, 12) = Sheets("E").Cells(2, 12)
'Sheets("T").Cells(1, 13) = Sheets("E").Cells(2, 13)
'Sheets("T").Cells(1, 14) = Sheets("E").Cells(2, 14)
'Sheets("T").Cells(1, 15) = Sheets("E").Cells(2, 15)
'Sheets("T").Cells(1, 16) = Sheets("E").Cells(2, 16)
'Sheets("T").Cells(1, 17) = Sheets("E").Cells(2, 17)
'Sheets("T").Cells(1, 18) = Sheets("E").Cells(2, 18)
'Sheets("T").Cells(1, 19) = Sheets("E").Cells(2, 19)
'Sheets("T").Cells(1, 20) = Sheets("E").Cells(2, 20)
'Sheets("T").Cells(1, 21) = Sheets("E").Cells(2, 21)


Sheets("T").Cells(cont + 1, 1) = Sheets("E").Cells(1, 1)
Sheets("T").Cells(cont + 1, 2) = Sheets("E").Cells(1, 2)
Sheets("T").Cells(cont + 1, 3) = Sheets("E").Cells(1, 3)
Sheets("T").Cells(cont + 1, 4) = Sheets("E").Cells(1, 4)
Sheets("T").Cells(cont + 1, 5) = Sheets("E").Cells(1, 5)
Sheets("T").Cells(cont + 1, 6) = Sheets("E").Cells(1, 6)
'Sheets("T").Cells(cont + 1, 7) = Sheets("E").Cells(1, 7)
'Sheets("T").Cells(cont + 1, 8) = Sheets("E").Cells(1, 8)
'Sheets("T").Cells(cont + 1, 9) = Sheets("E").Cells(1, 9)
'Sheets("T").Cells(cont + 1, 10) = Sheets("E").Cells(1, 10)
'Sheets("T").Cells(cont + 1, 11) = Sheets("E").Cells(1, 11)
'Sheets("T").Cells(cont + 1, 12) = Sheets("E").Cells(1, 12)
'Sheets("T").Cells(cont + 1, 13) = Sheets("E").Cells(1, 13)
'Sheets("T").Cells(cont + 1, 14) = Sheets("E").Cells(1, 14)
'Sheets("T").Cells(cont + 1, 15) = Sheets("E").Cells(1, 15)
'Sheets("T").Cells(cont + 1, 16) = Sheets("E").Cells(1, 16)
'Sheets("T").Cells(cont + 1, 17) = Sheets("E").Cells(1, 17)
'Sheets("T").Cells(cont + 1, 18) = Sheets("E").Cells(1, 18)
'Sheets("T").Cells(cont + 1, 19) = Sheets("E").Cells(1, 19)
'Sheets("T").Cells(cont + 1, 20) = Sheets("E").Cells(1, 20)
'Sheets("T").Cells(cont + 1, 21) = Sheets("E").Cells(1, 21)


Call maquinas
Call actividad
Call material
Call generalidades
Call mantenimiento
Call bruto
Call mrp

timefin = Now
Sheets("T").Cells(cont + 1, 8) = timefin
Call CommandButton1_Click


cont = cont + 1
Next
Next
Next
Next
'Next
'Next
'Next
'Next
'Next
'Next
'Next
'Next
'Next
'Next
'Next
'Next

End Sub


