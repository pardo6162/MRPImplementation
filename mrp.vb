Sub mrp()
	
	Dim timefin As Date
	Dim num1 As Double
	Dim num2 As Double
	Dim suma As Integer

	fu = Cells(Rows.Count, 1).End(xlUp).Row 'A1048576

	numat = Cells(1, 4)
	tiempo = Cells(1, 3)
	'parte 1
	'************************************************************************************************************
	For t = 1 To tiempo
		For n = 1 To numat
			For gen = 2 To 10

				bgen = "Generalidades"
				Range("a1").Select
				Cells.Find(What:=bgen, After:=ActiveCell, LookIn:=xlValues, LookAt:= _
		    			xlPart, SearchOrder:=xlByRows, SearchDirection:=xlNext, MatchCase:=False _
		    			, SearchFormat:=False).Activate
		    
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
	'****************************************************************************************************************
	'parte2
	For n = 1 To numat
		For t = 1 To tiempo

			Cells(fu + 8 + (n * 15), 1) = "Requerimiento neto"
	    		If Cells(fu + 6 + (n * 15), t + 6) <= Cells(fu + 3 + (n * 15), 2) Then
				Cells(fu + 8 + (n * 15), t + 6) = Cells(fu + 3 + (n * 15), 2) - Cells(fu + 6 + (n * 15), t + 6)
			Else
				Cells(fu + 8 + (n * 15), t + 6) = 0
	    		End If

			Cells(fu + 9 + (n * 15), 1) = "Recepciones planeadas"

			'Lote a lote
			If Cells(fu + 3 + (n * 15), 9) = 0 Then
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
		
			'Balanceo de periodo balanceado
	    		ElseIf Cells(fu + 3 + (n * 15), 9) = 5 Then
	    
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
